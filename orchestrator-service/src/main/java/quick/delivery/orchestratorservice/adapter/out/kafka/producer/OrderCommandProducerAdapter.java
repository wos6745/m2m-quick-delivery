package quick.delivery.orchestratorservice.adapter.out.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import quick.delivery.annotation.ProducerAdapter;
import quick.delivery.message.command.CreateOrderMessage;
import quick.delivery.message.command.OrderCommandEvent;
import quick.delivery.orchestratorservice.application.port.out.OrderCommandPort;

@ProducerAdapter
@RequiredArgsConstructor
@Slf4j
public class OrderCommandProducerAdapter implements OrderCommandPort {

    @Value("${app.kafka.topics.orchestrator-order}")
    private final String topic;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public <T> void sendOrderCommand(OrderCommandEvent<T> message) {

        kafkaTemplate.send(topic, message.sagaId(), message)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        log.info("카프카 명령 전송 성공 - SagaId: {}, Offset: {}",
                                message.sagaId(), result.getRecordMetadata().offset());
                    } else {
                        log.error("카프카 명령 전송 실패 - SagaId: {}", message.sagaId(), ex);
                    }
                });
    }
}
