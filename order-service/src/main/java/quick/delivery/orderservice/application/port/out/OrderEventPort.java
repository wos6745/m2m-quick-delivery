package quick.delivery.orderservice.application.port.out;

import quick.delivery.common.event.OrderCreatedEvent;
import quick.delivery.message.reply.CreateOrderReply;

public interface OrderEventPort {
    void sendOrderCreatedEvent(CreateOrderReply reply);
}
