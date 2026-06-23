package quick.delivery.message.command.payment;

import lombok.Builder;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.PaymentStatus;

public record CreatePaymentMessage(
    String sagaId,
    String orderId,
    String userId,
    Long totalPoints,
    PaymentStatus status
) {
    @Builder
    public CreatePaymentMessage {
    }
}
