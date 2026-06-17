package quick.delivery.orchestratorservice.common.dto;

import lombok.Builder;
import quick.delivery.common.Supports.SagaProcessStatus;
import quick.delivery.common.Supports.SagaStatus;

public record UpdateSagaInstanceStatusDto(
        String sagaId,
        Long orderId,
        SagaProcessStatus sagaStatus
) {
    @Builder
    public UpdateSagaInstanceStatusDto {
    }
}
