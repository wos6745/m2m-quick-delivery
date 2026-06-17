package quick.delivery.message.reply;

import lombok.Builder;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.KafkaCommandType;

public record OrderCommandReply(
        String sagaId,
        Long orderId,
        KafkaCommandType commandType,
        boolean status,
        String message
) {
    @Builder
    public OrderCommandReply {
    }
}
