package quick.delivery.orderservice.application.port.out;

import quick.delivery.common.event.OrderCreatedEvent;

public interface OrderEventPort {
    void sendOrderCreatedEvent(OrderCreatedEvent event);
}
