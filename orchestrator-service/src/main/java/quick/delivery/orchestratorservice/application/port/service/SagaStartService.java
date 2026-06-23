package quick.delivery.orchestratorservice.application.port.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quick.delivery.common.Supports.*;
import quick.delivery.dto.request.BffCreateOrderRequest;
import quick.delivery.message.command.order.CreateOrderItemMessage;
import quick.delivery.message.command.order.CreateOrderMessage;
import quick.delivery.message.command.order.OrderCommandEvent;
import quick.delivery.orchestratorservice.application.port.in.SagaStartUseCase;
import quick.delivery.orchestratorservice.application.port.out.OrderCommandPort;
import quick.delivery.orchestratorservice.application.port.out.SagaInstancePort;
import quick.delivery.orchestratorservice.common.dto.SaveSagaInstanceDto;
import quick.delivery.orchestratorservice.common.result.SaveSagaInstanceResult;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class SagaStartService implements SagaStartUseCase {
    private final SagaInstancePort sagaInstancePort;
    private final OrderCommandPort orderCommandPort;

    @Override
    public String initiateOrderSaga(BffCreateOrderRequest req) {
        String sagaId = UUID.randomUUID().toString();

        SaveSagaInstanceDto dto = SaveSagaInstanceDto.builder()
                .sagaId(sagaId)
                .sagaStatus(SagaProcessStatus.INITIATED)
                .orderId(0L)
                .build();

        SaveSagaInstanceResult saveSagaInstanceResult = sagaInstancePort.save(dto);

        CreateOrderMessage createOrderMessage = CreateOrderMessage.builder()
                .userId(req.userId())
                .deliveryAddress(req.deliveryAddress())
                .deliveryMessage(req.deliveryMessage())
                .storeMessage(req.storeMessage())
                .totalPoints(req.totalPoints())
                .orderItems(req.orderItems().stream()
                        .map(x -> CreateOrderItemMessage.builder()
                                .count(x.count())
                                .price(x.price())
                                .menuId(x.menuId())
                                .build())
                        .toList())
                .build();

        OrderCommandEvent<CreateOrderMessage> event = OrderCommandEvent.<CreateOrderMessage>builder()
                .sagaId(saveSagaInstanceResult.sagaId())
                .payload(createOrderMessage)
                .commandType(KafkaCommandType.CREATE_ORDER)
                .build();

        orderCommandPort.sendOrderCommand(event);

        return saveSagaInstanceResult.sagaId();
    }
}
