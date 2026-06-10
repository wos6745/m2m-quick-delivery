package quick.delivery.orderservice.application.port.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quick.delivery.orderservice.application.port.command.CreateOrderCommand;
import quick.delivery.orderservice.application.port.in.CreateOrderItemUseCase;
import quick.delivery.orderservice.application.port.in.CreateOrderUseCase;
import quick.delivery.orderservice.application.port.response.CreateOrderResponse;
import quick.delivery.orderservice.infrastructure.adapter.in.web.payload.request.CreateOrderRequest;

@Service
@RequiredArgsConstructor
public class OrderService implements CreateOrderUseCase {
    private CreateOrderItemUseCase createOrderItemUseCase;

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand req) {
        return null;
    }
}
