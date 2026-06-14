package quick.delivery.orchestratorservice.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import quick.delivery.orchestratorservice.adapter.out.persistence.entity.SagaInstanceEntity;

public interface SagaInstanceJpaRepository extends JpaRepository<SagaInstanceEntity, Long> {
}
