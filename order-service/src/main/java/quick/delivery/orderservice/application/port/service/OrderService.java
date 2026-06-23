package quick.delivery.orderservice.application.port.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import quick.delivery.exception.CreateOrderException;
import quick.delivery.message.reply.order.OrderCommandReply;
import quick.delivery.orderservice.application.port.command.CreateOrderCommand;
import quick.delivery.orderservice.application.port.command.CreateOrderItemCommand;
import quick.delivery.orderservice.application.port.command.SaveOrderCommand;
import quick.delivery.orderservice.application.port.in.CreateOrderItemUseCase;
import quick.delivery.orderservice.application.port.in.CreateOrderUseCase;
import quick.delivery.orderservice.application.port.out.OrderEventPort;
import quick.delivery.orderservice.application.port.out.SaveOrderPort;
import quick.delivery.orderservice.application.port.response.SaveOrderResponse;
import quick.delivery.orderservice.domain.Order;
import tools.jackson.databind.ObjectMapper;

import static quick.delivery.common.Supports.ErrorCode.*;

@Service
@RequiredArgsConstructor
class OrderService implements CreateOrderUseCase {
    private final CreateOrderItemUseCase createOrderItemUseCase;
    private final SaveOrderPort saveOrderPort;
    private final OrderEventPort orderEventPort;
    private final ObjectMapper objectMapper;

    @Override
    @Transactional
    public void createOrder(CreateOrderCommand command) {
        Order order = command.toEntity();
        order.validateCreateOrder();

        SaveOrderCommand saveOrderCommand = command.toCommand();
        SaveOrderResponse saveOrderResponse = saveOrderPort.saveOrder(saveOrderCommand);

        if (!saveOrderResponse.isSuccess()) {
            String jsonPayload = objectMapper.writeValueAsString(command);
            throw new CreateOrderException(ORDER_ENTITY_SAVE_FAIL, jsonPayload);
        }

        CreateOrderItemCommand orderItemCommand = CreateOrderItemCommand.builder()
                .orderItems(command.orderItems())
                .build();

        createOrderItemUseCase.createOrderItem(orderItemCommand);
        
        // 카프카 통신
        OrderCommandReply reply = OrderCommandReply.builder()
                .orderId(saveOrderResponse.orderId())
                .sagaId(command.sagaId())
                .status(true)
                .totalPoints(command.totalPoints())
                .commandType(command.commandType())
                .userId(command.userId())
                .message("")
                .build();

        orderEventPort.sendOrderCreatedEvent(reply);
    }
}
