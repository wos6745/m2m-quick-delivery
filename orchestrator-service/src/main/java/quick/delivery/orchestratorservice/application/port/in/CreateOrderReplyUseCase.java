package quick.delivery.orchestratorservice.application.port.in;

import quick.delivery.message.reply.OrderCommandReply;

public interface CreateOrderReplyUseCase {
    void handleOrderReply(OrderCommandReply reply);
}
