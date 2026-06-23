package quick.delivery.orderservice.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.OrderStatus;
import quick.delivery.orderservice.application.port.command.SaveOrderCommand;
import quick.delivery.orderservice.domain.Order;
import quick.delivery.orderservice.infrastructure.adapter.out.persistence.entity.base.JpaBaseTimeEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@Table(name = "Order", indexes = @Index(name = "idx_order_id", columnList = "orderId", unique = true))
public class OrderEntity extends JpaBaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String orderId;
    private String userId;
    private String deliveryAddress;
    private String deliveryMessage;
    private String storeMessage;
    private OrderStatus orderStatus;
    private String cancelMessage;
    private Long totalPoints;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @Builder.Default
    private List<OrderItemEntity> orderItems = new ArrayList<>();

    public static OrderEntity convertSaveEntity(SaveOrderCommand command) {
        return OrderEntity.builder()
                .orderId(UUID.randomUUID().toString())
                .userId(command.userId())
                .deliveryAddress(command.deliveryAddress())
                .deliveryMessage(command.deliveryMessage())
                .storeMessage(command.storeMessage())
                .orderStatus(OrderStatus.WAITING)
                .cancelMessage("")
                .totalPoints(command.totalPoints())
                .build();
    }
}
