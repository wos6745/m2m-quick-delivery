package quick.delivery.message.command;

import lombok.Builder;

import java.util.List;

public record CreateOrderMessage(
        Long sagaId,
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
