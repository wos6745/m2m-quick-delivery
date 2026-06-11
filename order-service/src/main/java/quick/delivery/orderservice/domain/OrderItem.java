package quick.delivery.orderservice.domain;

import lombok.Builder;
import quick.delivery.exception.OrderItemCreateException;

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
        if (price == null) {
            throw new OrderItemCreateException(ORDER_ITEM_CREATE_VALIDATION_FAIL, "price is null");
        }
        if (count == 0) {
            throw new OrderItemCreateException(ORDER_ITEM_CREATE_VALIDATION_FAIL, "count is zero");
        }
        if (menuId == null) {
            throw new OrderItemCreateException(ORDER_ITEM_CREATE_VALIDATION_FAIL, "menuId is null");
        }
    }
}
