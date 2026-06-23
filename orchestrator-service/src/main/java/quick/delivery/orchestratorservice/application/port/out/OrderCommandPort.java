package quick.delivery.orchestratorservice.application.port.out;

import quick.delivery.message.command.order.OrderCommandEvent;

public interface OrderCommandPort {
    <T> void sendOrderCommand(OrderCommandEvent<T> event);
}
