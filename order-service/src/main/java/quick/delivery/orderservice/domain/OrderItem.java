package quick.delivery.orderservice.domain;

import lombok.Builder;
import quick.delivery.exception.OrderItemCreateException;

import static quick.delivery.common.Supports.ErrorCode.ORDER_ITEM_CREATE_VALIDATION_FAIL;

public class OrderItem {
    private Long id;
    private Long orderItemId;
    private int count;
    private Long price;

    @Builder
    public OrderItem(int count, Long price) {
        validateCreateOrderItem(price);
        this.count = count;
        this.price = price;
    }

    public void validateCreateOrderItem(Long price) {
        if (price == null) {
            throw new OrderItemCreateException(ORDER_ITEM_CREATE_VALIDATION_FAIL, "price is null");
        }
        if (count == 0) {
            throw new OrderItemCreateException(ORDER_ITEM_CREATE_VALIDATION_FAIL, "count is zero");
        }
    }
}
