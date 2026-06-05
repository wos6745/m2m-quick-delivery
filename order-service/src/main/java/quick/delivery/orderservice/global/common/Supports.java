package quick.delivery.orderservice.global.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


public interface Supports {
    @RequiredArgsConstructor
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
    }

    @Getter
    @RequiredArgsConstructor
    enum ErrorCode {
        ORDER_CREATE_VALIDATION_FAIL(10000, "validation fail");
        private final int code;
        private final String errorMessage;
    }
}
