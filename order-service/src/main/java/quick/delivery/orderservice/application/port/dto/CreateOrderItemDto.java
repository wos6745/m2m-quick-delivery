package quick.delivery.orderservice.application.port.dto;

import lombok.Builder;
import quick.delivery.orderservice.application.port.command.SaveOrderItemCommand;
import quick.delivery.orderservice.domain.OrderItem;

public record CreateOrderItemDto(
        Long menuId,
        Long price,
        int count
) {
    @Builder
    public CreateOrderItemDto {
    }

    public OrderItem toEntity() {
        OrderItem entity = OrderItem.builder()
                .menuId(menuId)
                .count(count)
                .price(price)
                .build();

        entity.validateCreateOrderItem();

        return entity;
    }

    public SaveOrderItemCommand toCommand() {
        return SaveOrderItemCommand.builder()
                .menuId(menuId)
                .price(price)
                .count(count)
                .build();
    }
}
