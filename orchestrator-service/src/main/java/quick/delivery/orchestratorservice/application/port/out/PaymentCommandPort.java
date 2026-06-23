package quick.delivery.orchestratorservice.application.port.out;

import quick.delivery.message.command.payment.PaymentCommandEvent;

public interface PaymentCommandPort {
    <T> void sendPaymentCommand(PaymentCommandEvent<T> event);
}
