package quick.delivery.message.command;

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
