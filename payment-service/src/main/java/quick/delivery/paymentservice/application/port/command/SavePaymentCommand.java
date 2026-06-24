package quick.delivery.paymentservice.application.port.command;

import lombok.Builder;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.PaymentStatus;

public record SavePaymentCommand(
        String sagaId,
        String orderId,
        String userId,
        Long totalPoints,
        PaymentStatus status
) {
    @Builder
    public SavePaymentCommand {
    }


}
