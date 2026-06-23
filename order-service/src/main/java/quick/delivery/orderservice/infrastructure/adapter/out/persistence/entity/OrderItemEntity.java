package quick.delivery.orderservice.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import quick.delivery.orderservice.application.port.command.SaveOrderItemCommand;
import quick.delivery.orderservice.infrastructure.adapter.out.persistence.entity.base.JpaBaseTimeEntity;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@Table(name = "OrderItem", indexes = @Index(name = "idx_order_item_id", columnList = "orderItemId", unique = true))
public class OrderItemEntity extends JpaBaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String orderItemId;
    private Long menuId;
    private int count;
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public static OrderItemEntity convertSaveEntity(SaveOrderItemCommand command) {
        return  OrderItemEntity.builder()
                .orderItemId(UUID.randomUUID().toString())
                .menuId(command.menuId())
                .count(command.count())
                .price(command.price())
                .build();
    }
}
