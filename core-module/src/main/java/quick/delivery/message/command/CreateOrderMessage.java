package quick.delivery.message.command;

import lombok.Builder;
import quick.delivery.common.Supports.KafkaCommandType;

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
