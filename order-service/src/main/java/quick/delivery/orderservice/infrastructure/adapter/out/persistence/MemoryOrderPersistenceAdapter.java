package quick.delivery.orderservice.infrastructure.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import quick.delivery.annotation.PersistenceAdapter;
import quick.delivery.orderservice.application.port.command.SaveOrderCommand;
import quick.delivery.orderservice.application.port.out.SaveOrderPort;
import quick.delivery.orderservice.application.port.response.SaveOrderResponse;
import quick.delivery.orderservice.infrastructure.adapter.out.persistence.jpa.OrderJpaRepository;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemoryOrderPersistenceAdapter implements SaveOrderPort {
    private OrderJpaRepository orderJpaRepository;
    @Override
    public SaveOrderResponse saveOrder(SaveOrderCommand command) {
        return null;
    }
}
