package quick.delivery.paymentservice.domain;

import lombok.Builder;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.PaymentStatus;
import quick.delivery.exception.CreateOrderException;
import quick.delivery.exception.CreatePaymentException;

import static quick.delivery.common.Supports.ErrorCode.PAYMENT_CREATE_VALIDATION_FAIL;

public class Payment {
    private String sagaId;
    private String orderId;
    private String userId;
    private Long totalPoints;
    private PaymentStatus status;

    @Builder
    public Payment(String sagaId, String orderId, String userId, Long totalPoints, PaymentStatus status) {
        this.sagaId = sagaId;
        this.orderId = orderId;
        this.userId = userId;
        this.totalPoints = totalPoints;
        this.status = status;
    }


    public void validateCreatePayment() {
        if (userId == null || userId.isBlank()) {
            throw new CreatePaymentException(PAYMENT_CREATE_VALIDATION_FAIL, "userId is required");
        }

        if (sagaId == null || sagaId.isBlank()) {
            throw new CreatePaymentException(PAYMENT_CREATE_VALIDATION_FAIL, "sagaId is required");
        }
        if (orderId == null || orderId.isBlank()) {
            throw new CreatePaymentException(PAYMENT_CREATE_VALIDATION_FAIL, "orderId is required");
        }
    }
}
