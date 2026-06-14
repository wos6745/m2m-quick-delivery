package quick.delivery.common;

import lombok.Getter;

public interface Supports {
    enum SagaStatus {
        INITIATED(100, "예약 접수 중 입니다."),
        COMPLETED(200, "예약이 완료 되었습니다.");
        @Getter
        private final int code;
        @Getter
        private final String infoMessage;

        SagaStatus(int code, String infoMessage) {
            this.code = code;
            this.infoMessage = infoMessage;
        }
    }

    enum SagaProcessStatus {
        INITIATED(100),
        COMPLETED(200);
        @Getter
        private final int code;

        SagaProcessStatus(int code) {
            this.code = code;
        }
    }

    enum ResultCode {

        SUCCESS(20000, "성공"),
        INTERNAL_SERVER_ERROR(50000, "알 수 없는 서버 에러");

        @Getter
        private final int code;
        @Getter
        private final String infoMessage;

        ResultCode(int code, String infoMessage) {
            this.code = code;
            this.infoMessage = infoMessage;
        }
    }

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
        ORDER_CREATE_VALIDATION_FAIL(10000, "validation fail"),
        ORDER_ITEM_CREATE_VALIDATION_FAIL(10001, "validation fail"),
        ORDER_ENTITY_SAVE_FAIL(10002, "order entity save fail"),
        ORDER_ITEM_ENTITY_SAVE_FAIL(10003, "order item entity save fail");
        private final int code;
        private final String errorMessage;

        ErrorCode(int code, String errorMessage) {
            this.code = code;
            this.errorMessage = errorMessage;
        }
    }
}

