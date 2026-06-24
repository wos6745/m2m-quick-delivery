package quick.delivery.paymentservice.infrastructure.adapter.in.kafka.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import quick.delivery.annotation.ConsumerAdapter;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.KafkaCommandType;
import quick.delivery.message.command.order.CreateOrderMessage;
import quick.delivery.message.command.order.OrderCommandEvent;
import quick.delivery.message.command.payment.CreatePaymentMessage;
import quick.delivery.paymentservice.infrastructure.adapter.in.kafka.factory.PaymentCommandHandlerFactory;
import quick.delivery.paymentservice.infrastructure.adapter.in.kafka.handler.PaymentCommandHandler;
import tools.jackson.databind.ObjectMapper;

@ConsumerAdapter
@RequiredArgsConstructor
public class PaymentEventConsumerAdapter {
    private final PaymentCommandHandlerFactory paymentCommandHandlerFactory;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "${app.kafka.topics.orchestrator-payment}",
            groupId = "${app.kafka.groups.payment-service}")
    public void consumeOrderCommand(OrderCommandEvent<Object> event) {
        PaymentCommandHandler<Object> handler = paymentCommandHandlerFactory.getHandler(event.commandType());
        Object payload = objectMapper.convertValue(event.payload(), resolvePayloadType(event.commandType()));

        handler.handle(payload);
    }

    private Class<?> resolvePayloadType(KafkaCommandType commandType) {
        return switch (commandType) {
            case CREATE_ORDER -> null;
            case CREATE_PAYMENT -> CreatePaymentMessage.class;
        };
    }
}
