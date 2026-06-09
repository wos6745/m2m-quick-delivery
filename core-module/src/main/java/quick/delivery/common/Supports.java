package quick.delivery.common;

import lombok.Getter;

public interface Supports {
    enum OrderStatus {
        WAITING(100, "주문 대기 중"),
        CANCELED_STORE(200, "매장에서 취소 하였습니다."),
        CANCELED_CUSTOMER(201, "고객이 취소 하였습니다."),
        ACCEPTED(300, "조리가 시작 되었습니다."),
        DELIVERING(400, "배달중입니다."),
        DELIVERED(500, "배달이 완료 되었습니다.");

        @Getter
        private final int status;

        @Getter
        private final String statusMessage;

        OrderStatus(int status, String statusMessage) {
            this.status = status;
            this.statusMessage = statusMessage;
        }
    }

    @Getter
    enum ErrorCode {
        ORDER_CREATE_VALIDATION_FAIL(10000, "validation fail");
        private final int code;
        private final String errorMessage;

        ErrorCode(int code, String errorMessage) {
            this.code = code;
            this.errorMessage = errorMessage;
        }
    }
}

