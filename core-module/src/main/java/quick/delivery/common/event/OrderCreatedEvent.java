package quick.delivery.common.event;

import lombok.Builder;

import java.util.List;

public record OrderCreatedEvent(
        String orderId,
        String userId,
        Long totalPoints,
        String storeMessage,
        List<OrderItemEventDto> orderItems
) {

    @Builder
    public OrderCreatedEvent {
    }

    public record OrderItemEventDto(
            Long menuId,
            int count,
            Long price
    ) {
        @Builder
        public OrderItemEventDto {
        }
    }
}
