package quick.delivery.orderservice.infrastructure.adapter.in.kafka.handler;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import quick.delivery.common.Supports.KafkaCommandType;
import quick.delivery.message.command.order.CreateOrderMessage;
import quick.delivery.orderservice.application.port.command.CreateOrderCommand;
import quick.delivery.orderservice.application.port.dto.CreateOrderItemDto;
import quick.delivery.orderservice.application.port.in.CreateOrderUseCase;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CreateOrderCommandHandler implements OrderCommandHandler<CreateOrderMessage> {
    private final CreateOrderUseCase createOrderUseCase;

    @Override
    public KafkaCommandType getCommandType() {
        return KafkaCommandType.CREATE_ORDER;
    }

    @Override
    public void handle(CreateOrderMessage message) {
        List<CreateOrderItemDto> createOrderItemDtoList = message.orderItems()
                .stream()
                .map(x -> CreateOrderItemDto.builder()
                        .menuId(x.menuId())
                        .price(x.price())
                        .count(x.count())
                        .build())
                .toList();

        CreateOrderCommand command = CreateOrderCommand.builder()
                .userId(message.userId())
                .deliveryAddress(message.deliveryAddress())
                .deliveryMessage(message.deliveryMessage())
                .storeMessage(message.storeMessage())
                .totalPoints(message.totalPoints())
                .orderItems(createOrderItemDtoList)
                .commandType(getCommandType())
                .build();

        createOrderUseCase.createOrder(command);
    }
}
