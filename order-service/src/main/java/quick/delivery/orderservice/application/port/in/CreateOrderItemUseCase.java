package quick.delivery.orderservice.application.port.in;

import quick.delivery.orderservice.application.port.command.CreateOrderItemCommand;
import quick.delivery.orderservice.application.port.response.CreateOrderItemResponse;
import quick.delivery.orderservice.infrastructure.adapter.in.web.payload.request.CreateOrderItemRequest;

public interface CreateOrderItemUseCase {
    CreateOrderItemResponse createOrderItem(CreateOrderItemCommand command);
}
