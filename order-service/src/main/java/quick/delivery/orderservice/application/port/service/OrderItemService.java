package quick.delivery.orderservice.application.port.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quick.delivery.orderservice.application.port.command.CreateOrderItemCommand;
import quick.delivery.orderservice.application.port.in.CreateOrderItemUseCase;
import quick.delivery.orderservice.application.port.response.CreateOrderItemResponse;
import quick.delivery.orderservice.infrastructure.adapter.in.web.payload.request.CreateOrderItemRequest;

@Service
@RequiredArgsConstructor
public class OrderItemService implements CreateOrderItemUseCase {

    @Override
    public CreateOrderItemResponse createOrderItem(CreateOrderItemCommand command) {
        return null;
    }
}
