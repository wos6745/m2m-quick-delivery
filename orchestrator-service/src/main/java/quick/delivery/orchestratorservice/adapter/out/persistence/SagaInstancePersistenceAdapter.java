package quick.delivery.orchestratorservice.adapter.out.persistence;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import quick.delivery.annotation.PersistenceAdapter;
import quick.delivery.orchestratorservice.adapter.out.persistence.entity.SagaInstanceEntity;
import quick.delivery.orchestratorservice.adapter.out.persistence.jpa.SagaInstanceJpaRepository;
import quick.delivery.orchestratorservice.application.port.out.SagaInstancePort;
import quick.delivery.orchestratorservice.common.dto.SaveSagaInstanceDto;
import quick.delivery.orchestratorservice.common.dto.UpdateSagaInstanceStatusDto;
import quick.delivery.orchestratorservice.common.result.SaveSagaInstanceResult;
import quick.delivery.orchestratorservice.common.result.UpdateSagaInstanceStatusResult;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class SagaInstancePersistenceAdapter implements SagaInstancePort {
    private final SagaInstanceJpaRepository sagaInstanceJpaRepository;

    @Override
    public SaveSagaInstanceResult save(SaveSagaInstanceDto dto) {
        SagaInstanceEntity e = SagaInstanceEntity.builder()
                .sagaId(dto.sagaId())
                .sagaStatus(dto.sagaStatus())
                .orderId(dto.orderId())
                .build();

        SagaInstanceEntity resultEntity = sagaInstanceJpaRepository.save(e);

        return SaveSagaInstanceResult.builder()
                .sagaId(resultEntity.getSagaId())
                .build();
    }

    @Override
    public UpdateSagaInstanceStatusResult updateSagaStatus(UpdateSagaInstanceStatusDto dto) {
        SagaInstanceEntity sagaInstanceEntity = sagaInstanceJpaRepository.findBySagaId(dto.sagaId())
                .orElseThrow(EntityNotFoundException::new);

        sagaInstanceEntity.updateStatusAndOrderId(dto.sagaStatus(), dto.orderId());

        return UpdateSagaInstanceStatusResult.builder()
                .sagaId(sagaInstanceEntity.getSagaId())
                .build();
    }
}
