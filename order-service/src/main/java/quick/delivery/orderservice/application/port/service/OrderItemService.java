package quick.delivery.orderservice.application.port.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quick.delivery.exception.OrderItemCreateException;
import quick.delivery.orderservice.application.port.command.CreateOrderItemCommand;
import quick.delivery.orderservice.application.port.command.SaveOrderItemCommand;
import quick.delivery.orderservice.application.port.in.CreateOrderItemUseCase;
import quick.delivery.orderservice.application.port.out.SaveOrderItemPort;
import quick.delivery.orderservice.application.port.response.CreateOrderItemResponse;
import quick.delivery.orderservice.application.port.response.SaveOrderItemResponse;
import quick.delivery.orderservice.domain.OrderItem;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static quick.delivery.common.Supports.ErrorCode.ORDER_ITEM_ENTITY_SAVE_FAIL;

@Service
@RequiredArgsConstructor
class OrderItemService implements CreateOrderItemUseCase {
    private final SaveOrderItemPort saveOrderItemPort;
    private final ObjectMapper objectMapper;

    @Override
    public CreateOrderItemResponse createOrderItem(CreateOrderItemCommand command) {
        List<Long> orderItemIds = new ArrayList<>();

        command.orderItems().forEach(x -> {
            OrderItem orderItem = x.toEntity();
            orderItem.validateCreateOrderItem();

            SaveOrderItemCommand saveOrderItemCommand = x.toCommand();
            SaveOrderItemResponse saveOrderItemResponse = saveOrderItemPort.saveOrderItem(saveOrderItemCommand);

            if (!saveOrderItemResponse.isSuccess()) {
                String jsonPayload = objectMapper.writeValueAsString(x);
                throw new OrderItemCreateException(ORDER_ITEM_ENTITY_SAVE_FAIL, jsonPayload);
            }

            orderItemIds.add(saveOrderItemCommand.menuId());
        });

        return CreateOrderItemResponse.builder()
                .orderItemIds(orderItemIds)
                .build();
    }
}
