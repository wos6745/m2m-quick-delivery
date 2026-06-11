package quick.delivery.orderservice.domain;


import lombok.Builder;
import lombok.NoArgsConstructor;
import quick.delivery.common.Supports.OrderStatus;
import quick.delivery.exception.OrderCreateException;

import java.util.List;

import static quick.delivery.common.Supports.ErrorCode.*;

@NoArgsConstructor
public class Order {
    private Long id;
    private Long orderId;
    private String userId;
    private String deliveryAddress;
    private String deliveryMessage;
    private String storeMessage;
    private OrderStatus orderStatus;
    private String cancelMessage;
    private List<OrderItem> orderItems;
    private Long totalPoints;

    @Builder
    public Order(Long id, Long orderId, String userId, String deliveryAddress, String deliveryMessage, String storeMessage, OrderStatus orderStatus, String cancelMessage, List<OrderItem> orderItems, Long totalPoints) {
        this.id = id;
        this.orderId = orderId;
        this.userId = userId;
        this.deliveryAddress = deliveryAddress;
        this.deliveryMessage = deliveryMessage;
        this.storeMessage = storeMessage;
        this.orderStatus = orderStatus;
        this.cancelMessage = cancelMessage;
        this.orderItems = orderItems;
        this.totalPoints = totalPoints;
    }

    public void validateCreateOrder() throws OrderCreateException {
        if (userId == null || userId.isBlank()) {
            throw new OrderCreateException(ORDER_CREATE_VALIDATION_FAIL, "userId is required");
        }

        if (deliveryAddress == null || deliveryAddress.isBlank()) {
            throw new OrderCreateException(ORDER_CREATE_VALIDATION_FAIL, "deliveryAddress is required");
        }
        if (totalPoints == null || totalPoints == 0) {
            throw new OrderCreateException(ORDER_CREATE_VALIDATION_FAIL, "totalPoints is zero");
        }
        if (orderItems == null || orderItems.isEmpty()) {
            throw new OrderCreateException(ORDER_CREATE_VALIDATION_FAIL, "orderItems is required");
        }
    }
}
