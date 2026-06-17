package quick.delivery.response;


import lombok.Builder;
import quick.delivery.common.Supports.*;

public record SagaResponse(
        String sagaId,
        int sagaStatus,
        String sagaMessage
) {

    @Builder
    public SagaResponse {
    }
}
