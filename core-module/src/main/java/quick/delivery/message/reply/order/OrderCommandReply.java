package quick.delivery.message.reply.order;

import lombok.Builder;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.KafkaCommandType;

public record OrderCommandReply(
        String sagaId,
        String orderId,
        String userId,
        Long totalPoints,
        KafkaCommandType commandType,
        boolean status,
        String message
) {
    @Builder
    public OrderCommandReply {
    }
}
