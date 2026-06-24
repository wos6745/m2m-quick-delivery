package quick.delivery.paymentservice.infrastructure.adapter.in.kafka.factory;

import org.springframework.stereotype.Component;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.KafkaCommandType;
import quick.delivery.paymentservice.infrastructure.adapter.in.kafka.handler.PaymentCommandHandler;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PaymentCommandHandlerFactory {
    private final Map<KafkaCommandType, PaymentCommandHandler<?>> handlerMap;


    public PaymentCommandHandlerFactory(List<PaymentCommandHandler<?>> handlers) {
        this.handlerMap = handlers.stream()
                .collect(Collectors
                        .toMap(PaymentCommandHandler::getCommandType, Function.identity())
                );
    }

    @SuppressWarnings("unchecked")
    public <T> PaymentCommandHandler<T> getHandler(KafkaCommandType commandType) {
        PaymentCommandHandler<?> handler = handlerMap.get(commandType);

        return (PaymentCommandHandler<T>)handler;
    }
}
