package quick.delivery.orderservice.application.port.command;

import lombok.Builder;

public record SaveOrderItemCommand(
        Long menuId,
        Long price,
        int count
) {
    @Builder
    public SaveOrderItemCommand {
    }


}
