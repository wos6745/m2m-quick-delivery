package quick.delivery.orchestratorservice.adapter.in.kafka.consumer.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.KafkaCommandType;
import quick.delivery.orchestratorservice.adapter.in.kafka.consumer.handler.OrderReplyHandler;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class OrderReplyHandlerFactory {
    private final Map<KafkaCommandType, OrderReplyHandler<?>> handlerMap;

    public OrderReplyHandlerFactory(List<OrderReplyHandler<?>> handlerList) {
        handlerMap = handlerList.stream().collect(Collectors
                .toMap(OrderReplyHandler::getCommandType, Function.identity())
        );
    }

    @SuppressWarnings("unchecked")
    public <T> OrderReplyHandler<T> getHandler(KafkaCommandType commandType) {
        OrderReplyHandler<?> handler = handlerMap.get(commandType);

        return (OrderReplyHandler<T>)handler;
    }
}
