package quick.delivery.orchestratorservice.application.port.out;

import quick.delivery.message.command.CreateOrderMessage;

public interface OrderCommandPort {
    void sendOrderCommand(CreateOrderMessage message);
}
