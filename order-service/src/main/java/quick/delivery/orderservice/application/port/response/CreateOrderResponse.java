package quick.delivery.orderservice.application.port.response;

import lombok.Builder;

public record CreateOrderResponse(
        Long orderId
) {
    @Builder
    public CreateOrderResponse {
    }
}
