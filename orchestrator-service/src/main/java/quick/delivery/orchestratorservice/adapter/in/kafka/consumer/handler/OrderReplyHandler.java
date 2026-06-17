package quick.delivery.orchestratorservice.adapter.in.kafka.consumer.handler;

import quick.delivery.common.Supports;
import quick.delivery.common.Supports.KafkaCommandType;

public interface OrderReplyHandler<T> {
    KafkaCommandType getCommandType();

    void handle(T reply);
}
