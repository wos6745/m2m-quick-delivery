package quick.delivery.exception;

import lombok.Getter;
import quick.delivery.common.Supports.ErrorCode;

@Getter
public class CreateOrderException extends RuntimeException {
    private final String message;
    private final int code;

    public CreateOrderException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.message = errorCode.getErrorMessage();
        this.code = errorCode.getCode();
    }

    public CreateOrderException(ErrorCode errorCode, String additionalMessage) {
        super("%s %s".formatted(errorCode.getErrorMessage(), additionalMessage));
        this.message = "%s %s".formatted(errorCode.getErrorMessage(), additionalMessage);
        this.code = errorCode.getCode();
    }
}
