package quick.delivery.orderservice.infrastructure.adapter.out.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import quick.delivery.annotation.ProducerAdapter;
import quick.delivery.common.event.OrderCreatedEvent;
import quick.delivery.message.reply.CreateOrderReply;
import quick.delivery.orderservice.application.port.out.OrderEventPort;

@ProducerAdapter
@Slf4j
@RequiredArgsConstructor
public class OrderEventProducerAdapter implements OrderEventPort {
    private final KafkaTemplate<Long, CreateOrderReply> kafkaTemplate;

    public void sendOrderCreatedEvent(CreateOrderReply reply) {
        String topicName = "order-events";
        Long messageKey = reply.orderId();

        log.info("카프카 메시지 발행 시작 -> 토픽 : {}, 키 {}", topicName, messageKey);

        kafkaTemplate.send(topicName, messageKey, reply);
    }
}
