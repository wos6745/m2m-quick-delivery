package quick.delivery.orderservice.application.port.response;

import lombok.Builder;

public record SaveOrderItemResponse(
        boolean isSuccess,
        Long orderItemId
) {
    @Builder
    public SaveOrderItemResponse {
    }
}
