package quick.delivery.orchestratorservice.common.dto;

import lombok.Builder;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.SagaProcessStatus;
import quick.delivery.common.Supports.SagaStatus;

public record SaveSagaInstanceDto(
        SagaProcessStatus sagaStatus,
        Long orderId
) {
    @Builder
    public SaveSagaInstanceDto {
    }
}
