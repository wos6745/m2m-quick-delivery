package quick.delivery.orderservice.infrastructure.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import quick.delivery.annotation.PersistenceAdapter;
import quick.delivery.orderservice.application.port.command.SaveOrderCommand;
import quick.delivery.orderservice.application.port.out.SaveOrderPort;
import quick.delivery.orderservice.application.port.response.SaveOrderResponse;
import quick.delivery.orderservice.domain.Order;
import quick.delivery.orderservice.infrastructure.adapter.out.persistence.entity.OrderEntity;
import quick.delivery.orderservice.infrastructure.adapter.out.persistence.jpa.OrderJpaRepository;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemoryOrderPersistenceAdapter implements SaveOrderPort {
    private final OrderJpaRepository orderJpaRepository;

    @Override
    public SaveOrderResponse saveOrder(SaveOrderCommand command) {
        OrderEntity orderEntity = OrderEntity.convertSaveEntity(command);
        OrderEntity savedOrderEntity = orderJpaRepository.save(orderEntity);

        return SaveOrderResponse.builder()
                .orderId(savedOrderEntity.getId())
                .isSuccess(true)
                .build();
    }
}
