package quick.delivery.message.command.order;

import lombok.Builder;

import java.util.List;

public record CreateOrderMessage(
        String userId,
        String storeMessage,
        String deliveryAddress,
        String deliveryMessage,
        Long totalPoints,
        List<CreateOrderItemMessage> orderItems
) {
    @Builder
    public CreateOrderMessage {
    }
}
