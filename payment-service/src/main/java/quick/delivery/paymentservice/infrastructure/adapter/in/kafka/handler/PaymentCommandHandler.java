package quick.delivery.paymentservice.infrastructure.adapter.in.kafka.handler;

import quick.delivery.common.Supports;
import quick.delivery.common.Supports.KafkaCommandType;

public interface PaymentCommandHandler<T> {
    KafkaCommandType getCommandType();
    void handle(T message);
}
