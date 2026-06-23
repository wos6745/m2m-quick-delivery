package quick.delivery.orderservice.application.port.out;

import quick.delivery.message.reply.order.OrderCommandReply;

public interface OrderEventPort {
    void sendOrderCreatedEvent(OrderCommandReply reply);
}
