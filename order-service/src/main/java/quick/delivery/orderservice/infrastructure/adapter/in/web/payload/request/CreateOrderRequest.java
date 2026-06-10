package quick.delivery.orderservice.infrastructure.adapter.in.web.payload.request;

import quick.delivery.orderservice.application.port.command.CreateOrderCommand;

public record CreateOrderRequest() {

    public CreateOrderCommand toCommand() {
        return CreateOrderCommand.builder()
                .build();
    }
}
