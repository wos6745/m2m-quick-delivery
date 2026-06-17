package quick.delivery.orchestratorservice.common.result;

import lombok.Builder;

public record UpdateSagaInstanceStatusResult(
        String sagaId
) {
    @Builder
    public UpdateSagaInstanceStatusResult {
    }
}
