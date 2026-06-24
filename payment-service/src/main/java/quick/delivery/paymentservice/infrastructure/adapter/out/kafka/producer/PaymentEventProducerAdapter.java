package quick.delivery.paymentservice.infrastructure.adapter.out.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import quick.delivery.annotation.ProducerAdapter;
import quick.delivery.message.reply.order.OrderCommandReply;
import quick.delivery.message.reply.payment.PaymentCommandReply;
import quick.delivery.paymentservice.application.port.out.PaymentEventPort;

@ProducerAdapter
@Slf4j
public class PaymentEventProducerAdapter implements PaymentEventPort {
    private final String topic;
    private final KafkaTemplate<String, PaymentCommandReply> kafkaTemplate;

    public PaymentEventProducerAdapter(
            @Value("${app.kafka.topics.payment-orchestrator-reply}") String topic,
            KafkaTemplate<String, PaymentCommandReply> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendPaymentCreatedEvent(PaymentCommandReply reply) {
        String messageKey = String.valueOf(reply.paymentId());

        log.info("카프카 메시지 발행 시작 -> 토픽 : {}, 키 {}", topic, messageKey);

        kafkaTemplate.send(topic, messageKey, reply);
    }
}
