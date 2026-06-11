package quick.delivery.orderservice.infrastructure.adapter.in.web.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import quick.delivery.orderservice.application.port.command.CreateOrderCommand;
import java.util.List;

@Schema(description = "주문 생성 요청")
public record CreateOrderRequest(
        @Schema(description = "주문자 ID", example = "test")
        @NotBlank(message = "주문자 ID는 필수입니다.")
        String userId,
        @Schema(description = "가게 전달 메시지", example = "주문 메시지")
        String storeMessage,
        @Schema(description = "배송지", example = "서울시 성동구 금호동")
        @NotNull(message = "배송지 정보는 필수입니다.")
        String deliveryAddress,
        @Schema(description = "배송 요청 메시지", example = "빨리 가져다주세요")
        String deliveryMessage,
        @Schema(description = "사용 포인트", example = "1000")
        Long totalPoints,
        @Schema(description = "주문 상품 목록")
        @NotEmpty(message = "주문할 상품이 최소 하나 이상 있어야 합니다.")
        List<CreateOrderItemRequest> orderItems
) {
    public CreateOrderCommand toCommand() {
        return CreateOrderCommand.builder()
                .orderItems(orderItems().stream().map(CreateOrderItemRequest::toCommand).toList())
                .userId(userId)
                .storeMessage(storeMessage)
                .deliveryAddress(deliveryAddress)
                .deliveryMessage(deliveryMessage)
                .totalPoints(totalPoints)
                .build();
    }
}
