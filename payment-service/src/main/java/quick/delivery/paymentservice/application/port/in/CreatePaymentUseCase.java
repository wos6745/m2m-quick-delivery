package quick.delivery.paymentservice.application.port.in;

import quick.delivery.paymentservice.application.port.command.CreatePaymentCommand;

public interface CreatePaymentUseCase {
    void createPayment(CreatePaymentCommand command);
}
