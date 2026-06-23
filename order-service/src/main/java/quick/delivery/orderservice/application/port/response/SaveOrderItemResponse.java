package quick.delivery.orderservice.application.port.response;

import lombok.Builder;

public record SaveOrderItemResponse(
        boolean isSuccess,
        String orderItemId
) {
    @Builder
    public SaveOrderItemResponse {
    }
}
