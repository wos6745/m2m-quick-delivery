package quick.delivery.orchestratorservice.common.result;

import lombok.Builder;

public record SaveSagaInstanceResult(
    String sagaId
) {
    @Builder
    public SaveSagaInstanceResult {
    }
}
