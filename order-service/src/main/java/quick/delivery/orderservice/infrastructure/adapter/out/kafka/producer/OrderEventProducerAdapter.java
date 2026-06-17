package quick.delivery.orderservice.infrastructure.adapter.out.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import quick.delivery.annotation.ProducerAdapter;
import quick.delivery.message.reply.OrderCommandReply;
import quick.delivery.orderservice.application.port.out.OrderEventPort;

@ProducerAdapter
@Slf4j
@RequiredArgsConstructor
public class OrderEventProducerAdapter implements OrderEventPort {
    @Value("${app.kafka.topics.order-orchestrator-reply}")
    private final String topic;
    private final KafkaTemplate<Long, OrderCommandReply> kafkaTemplate;

    public void sendOrderCreatedEvent(OrderCommandReply reply) {
        Long messageKey = reply.orderId();

        log.info("카프카 메시지 발행 시작 -> 토픽 : {}, 키 {}", topic, messageKey);

        kafkaTemplate.send(topic, messageKey, reply);
    }
}
