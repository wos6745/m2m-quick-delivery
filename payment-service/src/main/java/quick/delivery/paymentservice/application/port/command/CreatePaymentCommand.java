package quick.delivery.paymentservice.application.port.command;

import lombok.Builder;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.PaymentStatus;

public record CreatePaymentCommand(
        String sagaId,
        String orderId,
        String userId,
        Long totalPoints,
        PaymentStatus status
) {
    @Builder
    public CreatePaymentCommand {
    }

    public SavePaymentCommand toSaveCommand() {
        return SavePaymentCommand.builder()
                .sagaId(sagaId)
                .orderId(orderId)
                .userId(userId)
                .totalPoints(totalPoints)
                .status(status)
                .build();
    }
}
