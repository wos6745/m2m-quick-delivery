package quick.delivery.orderservice.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import quick.delivery.common.Supports;
import quick.delivery.orderservice.infrastructure.adapter.out.persistence.entity.base.JpaBaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Order")
@Getter
@SuperBuilder
public class OrderEntity extends JpaBaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private Supports.OrderStatus orderStatus;
    private String cancelMessage;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @Builder.Default
    private List<OrderItemEntity> orderItems = new ArrayList<>();
}
