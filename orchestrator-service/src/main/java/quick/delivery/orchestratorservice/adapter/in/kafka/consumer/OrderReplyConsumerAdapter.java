package quick.delivery.orchestratorservice.adapter.in.kafka.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import quick.delivery.annotation.ConsumerAdapter;
import quick.delivery.message.reply.order.OrderCommandReply;
import quick.delivery.orchestratorservice.adapter.in.kafka.consumer.factory.OrderReplyHandlerFactory;
import quick.delivery.orchestratorservice.adapter.in.kafka.consumer.handler.OrderReplyHandler;

@ConsumerAdapter
@RequiredArgsConstructor
public class OrderReplyConsumerAdapter {
    private final OrderReplyHandlerFactory orderReplyHandlerFactory;

    @KafkaListener(topics = "${app.kafka.topics.order-orchestrator-reply}",
            groupId = "${app.kafka.groups.orchestrator}")
    public void consumeOrderReply(OrderCommandReply reply) {
        OrderReplyHandler<Object> handler = orderReplyHandlerFactory.getHandler(reply.commandType());

        handler.handle(reply);
    }
}
