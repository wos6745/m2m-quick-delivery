package quick.delivery.response;


import lombok.Builder;

@Builder
public record CommonResponse<T> (boolean success, int code, String message, T data) { }
