package quick.delivery.exception;

import quick.delivery.common.Supports;
import quick.delivery.common.Supports.ErrorCode;

public class OrderItemCreateException extends RuntimeException {
    private final String message;
    private final int code;


    public OrderItemCreateException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.message = errorCode.getErrorMessage();
        this.code = errorCode.getCode();
    }

    public OrderItemCreateException(ErrorCode errorCode, String additionalMessage) {
        super("%s %s".formatted(errorCode.getErrorMessage(), additionalMessage));
        this.message = "%s %s".formatted(errorCode.getErrorMessage(), additionalMessage);
        this.code = errorCode.getCode();
    }
}