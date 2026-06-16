package quick.delivery.orderservice.infrastructure.adapter.in.kafka.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import quick.delivery.annotation.ConsumerAdapter;

import quick.delivery.message.command.OrderCommandEvent;
import quick.delivery.orderservice.application.port.in.CreateOrderUseCase;
import quick.delivery.orderservice.infrastructure.adapter.in.kafka.factory.OrderCommandHandlerFactory;
import quick.delivery.orderservice.infrastructure.adapter.in.kafka.handler.OrderCommandHandler;

@RequiredArgsConstructor
@ConsumerAdapter
public class OrderEventConsumer {
    private final OrderCommandHandlerFactory orderCommandHandlerFactory;
    @KafkaListener(topics = "${app.kafka.topics.orchestrator-order}",
    groupId = "${app.kafka.groups.order-service}")
    public <T> void consumeOrderCommand(OrderCommandEvent<T> event) {
        OrderCommandHandler<Object> handler = orderCommandHandlerFactory.getHandler(event.commandType());
        handler.handle(event.payload());
    }
}
