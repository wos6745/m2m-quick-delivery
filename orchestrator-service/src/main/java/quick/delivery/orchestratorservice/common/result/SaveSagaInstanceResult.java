package quick.delivery.orchestratorservice.common.result;

import lombok.Builder;

public record SaveSagaInstanceResult(
    Long sagaId
) {
    @Builder
    public SaveSagaInstanceResult {
    }
}
