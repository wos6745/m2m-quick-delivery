package quick.delivery.paymentservice.application.port.out;

import quick.delivery.message.reply.payment.PaymentCommandReply;

public interface PaymentEventPort {
    void sendPaymentCreatedEvent(PaymentCommandReply reply);
}
