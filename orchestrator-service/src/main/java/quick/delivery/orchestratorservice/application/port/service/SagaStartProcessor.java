package quick.delivery.orchestratorservice.application.port.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quick.delivery.common.Supports.*;
import quick.delivery.dto.request.BffCreateOrderRequest;
import quick.delivery.message.command.CreateOrderItemMessage;
import quick.delivery.message.command.CreateOrderMessage;
import quick.delivery.message.command.OrderCommandEvent;
import quick.delivery.orchestratorservice.application.port.in.SagaStartService;
import quick.delivery.orchestratorservice.application.port.out.OrderCommandPort;
import quick.delivery.orchestratorservice.application.port.out.SagaInstancePort;
import quick.delivery.orchestratorservice.common.dto.SaveSagaInstanceDto;
import quick.delivery.orchestratorservice.common.result.SaveSagaInstanceResult;

@Service
@RequiredArgsConstructor
public class SagaStartProcessor implements SagaStartService {
    private final SagaInstancePort sagaInstancePort;
    private final OrderCommandPort orderCommandPort;

    @Override
    public Long initiateOrderSaga(BffCreateOrderRequest req) {

        SaveSagaInstanceDto dto = SaveSagaInstanceDto.builder()
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
