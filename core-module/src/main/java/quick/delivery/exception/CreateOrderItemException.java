package quick.delivery.exception;

import quick.delivery.common.Supports.ErrorCode;

public class CreateOrderItemException extends RuntimeException {
    private final String message;
    private final int code;


    public CreateOrderItemException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.message = errorCode.getErrorMessage();
        this.code = errorCode.getCode();
    }

    public CreateOrderItemException(ErrorCode errorCode, String additionalMessage) {
        super("%s %s".formatted(errorCode.getErrorMessage(), additionalMessage));
        this.message = "%s %s".formatted(errorCode.getErrorMessage(), additionalMessage);
        this.code = errorCode.getCode();
    }
}