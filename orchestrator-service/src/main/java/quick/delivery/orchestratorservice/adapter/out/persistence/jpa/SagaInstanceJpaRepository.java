package quick.delivery.orchestratorservice.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import quick.delivery.orchestratorservice.adapter.out.persistence.entity.SagaInstanceEntity;

import java.util.Optional;

public interface SagaInstanceJpaRepository extends JpaRepository<SagaInstanceEntity, Long> {
    Optional<SagaInstanceEntity> findBySagaId(String sagaId);
}
