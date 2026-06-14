package quck.delivery.bffservice.payload;

import lombok.Builder;

public record BffCreateOrderResponse(
        Long orderId
) {
    @Builder
    public BffCreateOrderResponse {
    }
}
