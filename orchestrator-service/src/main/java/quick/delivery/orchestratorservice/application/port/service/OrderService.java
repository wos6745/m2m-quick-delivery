package quick.delivery.orchestratorservice.application.port.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.PaymentStatus;
import quick.delivery.common.Supports.SagaProcessStatus;
import quick.delivery.message.command.payment.CreatePaymentMessage;
import quick.delivery.message.reply.order.OrderCommandReply;
import quick.delivery.orchestratorservice.application.port.in.CreateOrderReplyUseCase;
import quick.delivery.orchestratorservice.application.port.in.CreatePaymentUseCase;
import quick.delivery.orchestratorservice.application.port.out.SagaInstancePort;
import quick.delivery.orchestratorservice.common.dto.UpdateSagaInstanceStatusDto;
import quick.delivery.orchestratorservice.common.result.UpdateSagaInstanceStatusResult;

@Service
@RequiredArgsConstructor
public class OrderService implements CreateOrderReplyUseCase {
    private final SagaInstancePort sagaInstancePort;
    private final CreatePaymentUseCase createPaymentUseCase;

    @Override
    public void handleOrderReply(OrderCommandReply reply) {
        UpdateSagaInstanceStatusDto dto = UpdateSagaInstanceStatusDto.builder()
                .orderId(reply.orderId())
                .sagaId(reply.sagaId())
                .sagaStatus(reply.status() ? SagaProcessStatus.WAIT_PAYMENT : SagaProcessStatus.ORDER_CREATE_FAIL)
                .build();

        UpdateSagaInstanceStatusResult result = sagaInstancePort.updateSagaStatus(dto);

        CreatePaymentMessage message = CreatePaymentMessage.builder()
                .totalPoints(reply.totalPoints())
                .sagaId(result.sagaId())
                .status(PaymentStatus.WAIT_PAYMENT)
                .orderId(reply.orderId())
                .userId(reply.userId())
                .build();

        createPaymentUseCase.createPayment(message);
    }
}
