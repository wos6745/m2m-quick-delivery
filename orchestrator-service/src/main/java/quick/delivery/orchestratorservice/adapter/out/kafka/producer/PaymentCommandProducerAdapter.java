package quick.delivery.orchestratorservice.adapter.out.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import quick.delivery.annotation.ProducerAdapter;
import quick.delivery.message.command.payment.PaymentCommandEvent;
import quick.delivery.orchestratorservice.application.port.out.PaymentCommandPort;

@ProducerAdapter
@Slf4j
public class PaymentCommandProducerAdapter implements PaymentCommandPort {
    private final String topic;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PaymentCommandProducerAdapter(
            @Value("${app.kafka.topics.orchestrator-payment}") String topic,
            KafkaTemplate<String, Object> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public <T> void sendPaymentCommand(PaymentCommandEvent<T> event) {
        kafkaTemplate.send(topic, event.sagaId(), event).whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("카프카 명령 전송 성공 - SagaId: {}, Offset: {}", event.sagaId(), result.getRecordMetadata().offset());
            } else {
                log.error("카프카 명령 전송 실패 - SagaId: {}", event.sagaId(), ex);
            }
        });
    }
}
