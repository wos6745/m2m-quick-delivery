package quick.delivery.orderservice.application.port.command;

import lombok.Builder;
import quick.delivery.orderservice.domain.Order;

import java.util.List;

public record SaveOrderCommand(
        String userId,
        String storeMessage,
        String deliveryAddress,
        String deliveryMessage,
        Long totalPoints
) {
    @Builder
    public SaveOrderCommand {
    }
}
