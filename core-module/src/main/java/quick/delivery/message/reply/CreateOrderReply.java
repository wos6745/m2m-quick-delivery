package quick.delivery.message.reply;

import lombok.Builder;

public record CreateOrderReply(
        String orderId,
        boolean status,
        String message
) {
    @Builder
    public CreateOrderReply {
    }
}
