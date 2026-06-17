package quick.delivery.orchestratorservice.application.port.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quick.delivery.common.Supports.SagaProcessStatus;
import quick.delivery.message.reply.OrderCommandReply;
import quick.delivery.orchestratorservice.application.port.in.CreateOrderReplyUseCase;
import quick.delivery.orchestratorservice.application.port.out.SagaInstancePort;
import quick.delivery.orchestratorservice.common.dto.UpdateSagaInstanceStatusDto;
import quick.delivery.orchestratorservice.common.result.UpdateSagaInstanceStatusResult;

@Service
@RequiredArgsConstructor
public class CreateOrderReplyService implements CreateOrderReplyUseCase {
    private final SagaInstancePort sagaInstancePort;
    @Override
    public void handleOrderReply(OrderCommandReply reply) {
        UpdateSagaInstanceStatusDto dto = UpdateSagaInstanceStatusDto.builder()
                .orderId(reply.orderId())
                .sagaId(reply.sagaId())
                .sagaStatus(reply.status() ? SagaProcessStatus.WAIT_PAYMENT : SagaProcessStatus.ORDER_CREATE_FAIL)
                .build();

        UpdateSagaInstanceStatusResult result = sagaInstancePort.updateSagaStatus(dto);


    }
}
