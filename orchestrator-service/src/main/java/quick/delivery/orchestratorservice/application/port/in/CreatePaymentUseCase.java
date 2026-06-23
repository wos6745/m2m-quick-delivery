package quick.delivery.orchestratorservice.application.port.in;

import quick.delivery.message.command.payment.CreatePaymentMessage;

public interface CreatePaymentUseCase {
    void createPayment(CreatePaymentMessage message);
}
