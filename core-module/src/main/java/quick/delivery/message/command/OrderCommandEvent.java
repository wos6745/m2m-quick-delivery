package quick.delivery.message.command;

import lombok.Builder;
import quick.delivery.common.Supports.KafkaCommandType;

public record OrderCommandEvent<T>(
        Long sagaId,
        KafkaCommandType commandType,
        T payload
) {
    @Builder
    public OrderCommandEvent {
    }
}
