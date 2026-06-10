package quick.delivery.orderservice.application.port.out;

import quick.delivery.orderservice.application.port.command.SaveOrderItemCommand;
import quick.delivery.orderservice.application.port.response.SaveOrderItemResponse;

public interface SaveOrderItemPort {
    SaveOrderItemResponse saveOrderItem(SaveOrderItemCommand command);
}
