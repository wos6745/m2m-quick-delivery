package quick.delivery.paymentservice.application.port.out;

import quick.delivery.paymentservice.application.port.command.SavePaymentCommand;
import quick.delivery.paymentservice.application.port.response.SavePaymentResponse;

public interface PaymentCommandPort {
    SavePaymentResponse savePayment(SavePaymentCommand command);
}
