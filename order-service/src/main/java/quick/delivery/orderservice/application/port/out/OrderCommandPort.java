package quick.delivery.orderservice.application.port.out;

import quick.delivery.orderservice.application.port.command.SaveOrderCommand;
import quick.delivery.orderservice.application.port.response.SaveOrderResponse;

public interface OrderCommandPort {
    SaveOrderResponse saveOrder(SaveOrderCommand command);
}
