package quick.delivery.orderservice.infrastructure.adapter.in.kafka.consumer;

import tools.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import quick.delivery.annotation.ConsumerAdapter;
import quick.delivery.common.Supports.KafkaCommandType;
import quick.delivery.message.command.order.CreateOrderMessage;
import quick.delivery.message.command.order.OrderCommandEvent;
import quick.delivery.orderservice.infrastructure.adapter.in.kafka.factory.OrderCommandHandlerFactory;
import quick.delivery.orderservice.infrastructure.adapter.in.kafka.handler.OrderCommandHandler;

@ConsumerAdapter
@RequiredArgsConstructor
public class OrderEventConsumerAdapter {
    private final OrderCommandHandlerFactory orderCommandHandlerFactory;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "${app.kafka.topics.orchestrator-order}",
    groupId = "${app.kafka.groups.order-service}")
    public void consumeOrderCommand(OrderCommandEvent<Object> event) {
        OrderCommandHandler<Object> handler = orderCommandHandlerFactory.getHandler(event.commandType());
        Object payload = objectMapper.convertValue(event.payload(), resolvePayloadType(event.commandType()));
        handler.handle(payload);
    }

    private Class<?> resolvePayloadType(KafkaCommandType commandType) {
        return switch (commandType) {
            case CREATE_ORDER -> CreateOrderMessage.class;
            case CREATE_PAYMENT -> null;
        };
    }
}
