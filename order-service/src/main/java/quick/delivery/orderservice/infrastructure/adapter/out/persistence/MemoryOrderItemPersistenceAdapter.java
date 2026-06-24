package quick.delivery.orderservice.infrastructure.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import quick.delivery.annotation.PersistenceAdapter;
import quick.delivery.orderservice.application.port.command.SaveOrderItemCommand;
import quick.delivery.orderservice.application.port.out.OrderItemCommandPort;
import quick.delivery.orderservice.application.port.response.SaveOrderItemResponse;
import quick.delivery.orderservice.infrastructure.adapter.out.persistence.entity.OrderItemEntity;
import quick.delivery.orderservice.infrastructure.adapter.out.persistence.jpa.OrderItemJpaRepository;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemoryOrderItemPersistenceAdapter implements OrderItemCommandPort {
    private final OrderItemJpaRepository orderItemJpaRepository;
    @Override
    public SaveOrderItemResponse saveOrderItem(SaveOrderItemCommand command) {
        OrderItemEntity orderItemEntity = OrderItemEntity.convertSaveEntity(command);
        OrderItemEntity savedOrderItemEntity = orderItemJpaRepository.save(orderItemEntity);

        return SaveOrderItemResponse.builder()
                .orderItemId(savedOrderItemEntity.getOrderItemId())
                .isSuccess(true)
                .build();
    }
}
