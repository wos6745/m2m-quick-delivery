package quick.delivery.message.command.order;

import lombok.Builder;

public record CreateOrderItemMessage(

        Long menuId,
        Long price,
        int count
) {
    @Builder
    public CreateOrderItemMessage {
    }
}
