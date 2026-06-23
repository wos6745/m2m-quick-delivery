package quick.delivery.message.command.order;

import lombok.Builder;
import quick.delivery.common.Supports.KafkaCommandType;

public record OrderCommandEvent<T>(
        String sagaId,
        KafkaCommandType commandType,
        T payload
) {
    @Builder
    public OrderCommandEvent {
    }
}
