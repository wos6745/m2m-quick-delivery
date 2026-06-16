package quick.delivery.orderservice.infrastructure.adapter.in.kafka.handler;

import quick.delivery.common.Supports.KafkaCommandType;

public interface OrderCommandHandler<T> {
    KafkaCommandType getCommandType();
    void handle(T message);
}
