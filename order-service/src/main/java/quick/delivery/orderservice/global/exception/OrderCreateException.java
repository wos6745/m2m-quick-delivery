package quick.delivery.orderservice.global.exception;

import lombok.Getter;
import quick.delivery.orderservice.global.common.Supports;
import quick.delivery.orderservice.global.common.Supports.ErrorCode;

@Getter
public class OrderCreateException extends RuntimeException {
    private final String message;
    private final int code;

    public OrderCreateException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.message = errorCode.getErrorMessage();
        this.code = errorCode.getCode();
    }

    public OrderCreateException(ErrorCode errorCode, String additionalMessage) {
        super("%s %s".formatted(errorCode.getErrorMessage(), additionalMessage));
        this.message = "%s %s".formatted(errorCode.getErrorMessage(), additionalMessage);
        this.code = errorCode.getCode();
    }
}
