package quick.delivery.orchestratorservice.application.port.in;

import quick.delivery.message.reply.order.OrderCommandReply;

public interface CreateOrderReplyUseCase {
    void handleOrderReply(OrderCommandReply reply);
}
