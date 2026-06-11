package quick.delivery.orderservice.application.port.response;

import lombok.Builder;

import java.util.List;

public record CreateOrderItemResponse(
        List<Long> orderItemIds
) {
    @Builder
    public CreateOrderItemResponse {
    }
}
