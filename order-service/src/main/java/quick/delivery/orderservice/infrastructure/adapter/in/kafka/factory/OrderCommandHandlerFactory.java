package quick.delivery.orderservice.infrastructure.adapter.in.kafka.factory;

import org.springframework.stereotype.Component;
import quick.delivery.common.Supports.KafkaCommandType;
import quick.delivery.orderservice.infrastructure.adapter.in.kafka.handler.OrderCommandHandler;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class OrderCommandHandlerFactory {
    private final Map<KafkaCommandType, OrderCommandHandler<?>> handlerMap;


    public OrderCommandHandlerFactory(List<OrderCommandHandler<?>> handlers) {
        this.handlerMap = handlers.stream()
                .collect(Collectors
                        .toMap(OrderCommandHandler::getCommandType, Function.identity())
                );
    }

    @SuppressWarnings("unchecked")
    public <T> OrderCommandHandler<T> getHandler(KafkaCommandType commandType) {
        OrderCommandHandler<?> handler = handlerMap.get(commandType);

        return (OrderCommandHandler<T>)handler;
    }
}
