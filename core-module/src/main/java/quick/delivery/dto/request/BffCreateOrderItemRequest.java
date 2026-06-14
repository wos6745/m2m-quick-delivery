package quick.delivery.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

public record BffCreateOrderItemRequest(
        @Schema(description = "메뉴 ID", example = "1")
        @NotNull(message = "상품 ID는 필수입니다.")
        Long menuId,
        @Schema(description = "상품 가격", example = "3000")
        Long price,
        @Schema(description = "수량", example = "1")
        @NotNull(message = "수량은 필수입니다.")
        int count
) {
    @Builder
    public BffCreateOrderItemRequest {
    }
}
