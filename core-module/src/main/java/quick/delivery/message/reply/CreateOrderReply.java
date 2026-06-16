package quick.delivery.message.reply;

import lombok.Builder;

public record CreateOrderReply(
        Long sagaId,
        Long orderId,
        boolean status,
        String message
) {
    @Builder
    public CreateOrderReply {
    }
}
