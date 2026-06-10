package quick.delivery.orderservice.infrastructure.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import quick.delivery.annotation.PersistenceAdapter;
import quick.delivery.orderservice.application.port.command.SaveOrderItemCommand;
import quick.delivery.orderservice.application.port.out.SaveOrderItemPort;
import quick.delivery.orderservice.application.port.response.SaveOrderItemResponse;
import quick.delivery.orderservice.infrastructure.adapter.out.persistence.jpa.OrderItemJpaRepository;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemoryOrderItemPersistenceAdapter implements SaveOrderItemPort {
    private final OrderItemJpaRepository orderItemJpaRepository;
    @Override
    public SaveOrderItemResponse saveOrderItem(SaveOrderItemCommand command) {
        return null;
    }
}
