package quick.delivery.exception;

import quick.delivery.common.Supports;
import quick.delivery.common.Supports.ErrorCode;

public class CreatePaymentException extends RuntimeException {
    private final String message;
    private final int code;

    public CreatePaymentException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.message = errorCode.getErrorMessage();
        this.code = errorCode.getCode();
    }

    public CreatePaymentException(ErrorCode errorCode, String additionalMessage) {
        super("%s %s".formatted(errorCode.getErrorMessage(), additionalMessage));
        this.message = "%s %s".formatted(errorCode.getErrorMessage(), additionalMessage);
        this.code = errorCode.getCode();
    }
}
