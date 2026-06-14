package quick.delivery.orchestratorservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import quick.delivery.annotation.PersistenceAdapter;
import quick.delivery.orchestratorservice.adapter.out.persistence.entity.SagaInstanceEntity;
import quick.delivery.orchestratorservice.adapter.out.persistence.jpa.SagaInstanceJpaRepository;
import quick.delivery.orchestratorservice.application.port.out.SagaInstancePort;
import quick.delivery.orchestratorservice.common.dto.SaveSagaInstanceDto;
import quick.delivery.orchestratorservice.common.result.SaveSagaInstanceResult;

@PersistenceAdapter
@RequiredArgsConstructor
public class SagaInstancePersistenceAdapter implements SagaInstancePort {
    private final SagaInstanceJpaRepository sagaInstanceJpaRepository;

    @Override
    public SaveSagaInstanceResult save(SaveSagaInstanceDto dto) {
        SagaInstanceEntity e = SagaInstanceEntity.builder()
                .sagaStatus(dto.sagaStatus())
                .orderId(dto.orderId())
                .build();

        SagaInstanceEntity resultEntity = sagaInstanceJpaRepository.save(e);

        return SaveSagaInstanceResult.builder()
                .sagaId(resultEntity.getId())
                .build();
    }
}
