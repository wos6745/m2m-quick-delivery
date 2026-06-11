package quick.delivery.orderservice.infrastructure.adapter.in.web.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import quick.delivery.orderservice.application.port.dto.CreateOrderItemDto;

@Schema(description = "주문 상품")
public record CreateOrderItemRequest(
        @Schema(description = "메뉴 ID", example = "1")
        @NotNull(message = "상품 ID는 필수입니다.")
        Long menuId,
        @Schema(description = "상품 가격", example = "3000")
        Long price,
        @Schema(description = "수량", example = "1")
        @NotNull(message = "수량은 필수입니다.")
        int count
) {
    public CreateOrderItemDto toCommand() {
        return CreateOrderItemDto.builder()
                .menuId(menuId)
                .count(count)
                .price(price)
                .build();
    }
}
