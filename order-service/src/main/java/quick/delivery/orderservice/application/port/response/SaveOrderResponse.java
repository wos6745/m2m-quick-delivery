package quick.delivery.orderservice.application.port.response;

import lombok.Builder;

public record SaveOrderResponse(
        boolean isSuccess,
        String orderId
) {
    @Builder
    public SaveOrderResponse {
    }
}
