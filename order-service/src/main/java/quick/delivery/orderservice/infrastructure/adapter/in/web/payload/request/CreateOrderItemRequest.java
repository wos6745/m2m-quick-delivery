package quick.delivery.orderservice.infrastructure.adapter.in.web.payload.request;

import quick.delivery.orderservice.application.port.command.CreateOrderItemCommand;

public record CreateOrderItemRequest() {
    public CreateOrderItemCommand toCommand() {
        return CreateOrderItemCommand.builder()
                .build();
    }
}
