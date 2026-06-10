package quick.delivery.orderservice.infrastructure.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import quick.delivery.orderservice.infrastructure.adapter.out.persistence.entity.OrderItemEntity;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, Long> {
}
