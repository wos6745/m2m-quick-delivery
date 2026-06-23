package quick.delivery.orchestratorservice.adapter.in.kafka.consumer.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import quick.delivery.common.Supports.KafkaCommandType;
import quick.delivery.message.reply.order.OrderCommandReply;
import quick.delivery.orchestratorservice.application.port.in.CreateOrderReplyUseCase;

@Component
@RequiredArgsConstructor
public class CreateOrderReplyHandler implements OrderReplyHandler<OrderCommandReply>{
    private final CreateOrderReplyUseCase createOrderReplyUseCase;
    @Override
    public KafkaCommandType getCommandType() {
        return KafkaCommandType.CREATE_ORDER;
    }

    @Override
    public void handle(OrderCommandReply reply) {
        createOrderReplyUseCase.handleOrderReply(reply);
    }
}
