package quick.delivery.orderservice.application.port.command;

import lombok.Builder;
import quick.delivery.orderservice.application.port.dto.CreateOrderItemDto;
import quick.delivery.orderservice.domain.OrderItem;

import java.util.List;

public record CreateOrderItemCommand(
        List<CreateOrderItemDto> orderItems
) {
    @Builder
    public CreateOrderItemCommand {
    }
}
