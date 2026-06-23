package quick.delivery.orderservice.infrastructure.adapter.out.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import quick.delivery.annotation.ProducerAdapter;
import quick.delivery.message.reply.order.OrderCommandReply;
import quick.delivery.orderservice.application.port.out.OrderEventPort;

@ProducerAdapter
@Slf4j
public class OrderEventProducerAdapter implements OrderEventPort {
    private final String topic;
    private final KafkaTemplate<String, OrderCommandReply> kafkaTemplate;

    public OrderEventProducerAdapter(
            @Value("${app.kafka.topics.order-orchestrator-reply}") String topic,
            KafkaTemplate<String, OrderCommandReply> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderCreatedEvent(OrderCommandReply reply) {
        String messageKey = String.valueOf(reply.orderId());

        log.info("카프카 메시지 발행 시작 -> 토픽 : {}, 키 {}", topic, messageKey);

        kafkaTemplate.send(topic, messageKey, reply);
    }
}
