package quick.delivery.message.reply.payment;

import lombok.Builder;

public record PaymentCommandReply(
    String paymentId
) {
    @Builder
    public PaymentCommandReply {
    }
}
