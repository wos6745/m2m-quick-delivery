package quick.delivery.orchestratorservice.application.port.out;

import quick.delivery.message.command.CreateOrderMessage;
import quick.delivery.message.command.OrderCommandEvent;

public interface OrderCommandPort {
    <T> void sendOrderCommand(OrderCommandEvent<T> message);
}
