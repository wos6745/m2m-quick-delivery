package quick.delivery.paymentservice.application.port.response;

import lombok.Builder;

public record SavePaymentResponse(
        boolean isSuccess,
        String paymentId
) {
    @Builder
    public SavePaymentResponse {
    }
}
