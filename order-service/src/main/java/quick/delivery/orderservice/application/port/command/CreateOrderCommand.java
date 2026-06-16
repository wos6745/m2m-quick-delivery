package quick.delivery.orderservice.application.port.command;

import lombok.Builder;
import quick.delivery.orderservice.application.port.dto.CreateOrderItemDto;
import quick.delivery.orderservice.domain.Order;

import java.util.List;

public record CreateOrderCommand(
        Long sagaId,
        String userId,
        String storeMessage,
        String deliveryAddress,
        String deliveryMessage,
        Long totalPoints,
        List<CreateOrderItemDto> orderItems
) {
    @Builder
    public CreateOrderCommand {
    }

    public Order toEntity() {
        return Order.builder()
                .userId(userId)
                .storeMessage(storeMessage)
                .deliveryAddress(deliveryAddress)
                .deliveryMessage(deliveryMessage)
                .totalPoints(totalPoints)
                .orderItems(orderItems.stream().map(CreateOrderItemDto::toEntity).toList())
                .build();
    }

    public SaveOrderCommand toCommand() {
        return SaveOrderCommand.builder()
                .userId(userId)
                .storeMessage(storeMessage)
                .deliveryAddress(deliveryAddress)
                .deliveryMessage(deliveryMessage)
                .totalPoints(totalPoints)
                .build();
    }
}
