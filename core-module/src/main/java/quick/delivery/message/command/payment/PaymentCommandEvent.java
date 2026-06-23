package quick.delivery.message.command.payment;

import lombok.Builder;
import quick.delivery.common.Supports.KafkaCommandType;

public record PaymentCommandEvent<T>(
        String sagaId,
        KafkaCommandType commandType,
        T payload
) {
    @Builder
    public PaymentCommandEvent {
    }
}
