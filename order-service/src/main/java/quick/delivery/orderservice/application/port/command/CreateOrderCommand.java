package quick.delivery.orderservice.application.port.command;

import lombok.Builder;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.KafkaCommandType;
import quick.delivery.orderservice.application.port.dto.CreateOrderItemDto;
import quick.delivery.orderservice.domain.Order;

import java.util.List;

public record CreateOrderCommand(
        String sagaId,
        String userId,
        String storeMessage,
        String deliveryAddress,
        String deliveryMessage,
        Long totalPoints,
        KafkaCommandType commandType,
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
