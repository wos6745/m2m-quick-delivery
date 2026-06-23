package quick.delivery.orchestratorservice.application.port.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.KafkaCommandType;
import quick.delivery.message.command.order.CreateOrderMessage;
import quick.delivery.message.command.order.OrderCommandEvent;
import quick.delivery.message.command.payment.CreatePaymentMessage;
import quick.delivery.message.command.payment.PaymentCommandEvent;
import quick.delivery.orchestratorservice.application.port.in.CreatePaymentUseCase;
import quick.delivery.orchestratorservice.application.port.out.PaymentCommandPort;

@Service
@RequiredArgsConstructor
public class PaymentService implements CreatePaymentUseCase {
    private final PaymentCommandPort paymentCommandPort;
    @Override
    public void createPayment(CreatePaymentMessage message) {
        PaymentCommandEvent<CreatePaymentMessage> event = PaymentCommandEvent.<CreatePaymentMessage>builder()
                .sagaId(message.sagaId())
                .payload(message)
                .commandType(KafkaCommandType.CREATE_PAYMENT)
                .build();

        paymentCommandPort.sendPaymentCommand(event);
    }
}
