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
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private OrderStatus orderStatus;
    private String cancelMessage;
    private List<OrderItem> orderItemList;

    @Builder
    public Order(String customerId, String customerName ,String customerAddress, String customerPhoneNumber, List<OrderItem> orderItemList) {
        validateCreateOrder(customerId, customerName, customerAddress, customerPhoneNumber, orderItemList);

        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
        this.orderStatus = OrderStatus.WAITING;
        this.orderItemList = orderItemList;
    }

    private void validateCreateOrder(String customerId, String customerName ,String customerAddress, String customerPhoneNumber, List<OrderItem> orderItemList) throws OrderCreateException {
        if (customerId == null || customerId.isBlank()) {
            throw new OrderCreateException(ORDER_CREATE_VALIDATION_FAIL, "customerId is required");
        }
        if (customerName == null || customerName.isBlank()) {
            throw new OrderCreateException(ORDER_CREATE_VALIDATION_FAIL, "customerName is required");
        }

        if (customerAddress == null || customerAddress.isBlank()) {
            throw new OrderCreateException(ORDER_CREATE_VALIDATION_FAIL, "customerAddress is required");
        }
        if (customerPhoneNumber == null || customerPhoneNumber.isBlank()) {
            throw new OrderCreateException(ORDER_CREATE_VALIDATION_FAIL, "customerPhoneNumber is required");
        }
        if (orderItemList == null || orderItemList.isEmpty()) {
            throw new OrderCreateException(ORDER_CREATE_VALIDATION_FAIL, "orderItemList is required");
        }
    }
}
