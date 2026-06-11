package quick.delivery.orderservice.application.port.in;

import quick.delivery.orderservice.application.port.command.CreateOrderCommand;
import quick.delivery.orderservice.application.port.response.CreateOrderResponse;

public interface CreateOrderUseCase {
    CreateOrderResponse createOrder(CreateOrderCommand command);
}
