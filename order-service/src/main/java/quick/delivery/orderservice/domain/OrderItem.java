package quick.delivery.orderservice.domain;

import lombok.Builder;
import quick.delivery.exception.CreateOrderItemException;

import static quick.delivery.common.Supports.ErrorCode.ORDER_ITEM_CREATE_VALIDATION_FAIL;

public class OrderItem {
    private Long id;
    private Long orderItemId;
    private Long menuId;
    private int count;
    private Long price;

    @Builder
    public OrderItem(Long id, Long orderItemId, int count, Long price, Long menuId) {
        this.id = id;
        this.orderItemId = orderItemId;
        this.menuId = menuId;
        this.count = count;
        this.price = price;
    }

    public void validateCreateOrderItem() {
        if (count == 0) {
            throw new CreateOrderItemException(ORDER_ITEM_CREATE_VALIDATION_FAIL, "count is zero");
        }
        if (menuId == null) {
            throw new CreateOrderItemException(ORDER_ITEM_CREATE_VALIDATION_FAIL, "menuId is null");
        }
    }
}
