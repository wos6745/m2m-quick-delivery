package quick.delivery.paymentservice.infrastructure.adapter.in.kafka.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.KafkaCommandType;
import quick.delivery.message.command.payment.CreatePaymentMessage;
import quick.delivery.paymentservice.application.port.command.CreatePaymentCommand;
import quick.delivery.paymentservice.application.port.in.CreatePaymentUseCase;

@Component
@RequiredArgsConstructor
public class CreatePaymentCommanddHandler implements PaymentCommandHandler<CreatePaymentMessage> {
    private final CreatePaymentUseCase createPaymentUseCase;
    @Override
    public KafkaCommandType getCommandType() {
        return KafkaCommandType.CREATE_PAYMENT;
    }

    @Override
    public void handle(CreatePaymentMessage message) {
        CreatePaymentCommand command = CreatePaymentCommand.builder()
                .userId(message.userId())
                .sagaId(message.sagaId())
                .orderId(message.orderId())
                .totalPoints(message.totalPoints())
                .status(message.status())
                .build();

        createPaymentUseCase.createPayment(command);
    }
}
