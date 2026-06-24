package quick.delivery.paymentservice.infrastructure.adapter.out.kafka.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import quick.delivery.paymentservice.infrastructure.adapter.out.kafka.persistence.entity.PaymentEntity;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, Long> {
}
