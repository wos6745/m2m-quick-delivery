package quick.delivery.orderservice.application.port.in;

import quick.delivery.orderservice.application.port.command.CreateOrderItemCommand;
import quick.delivery.orderservice.application.port.dto.CreateOrderItemDto;
import quick.delivery.orderservice.application.port.response.CreateOrderItemResponse;

public interface CreateOrderItemUseCase {
    CreateOrderItemResponse createOrderItem(CreateOrderItemCommand command);
}
