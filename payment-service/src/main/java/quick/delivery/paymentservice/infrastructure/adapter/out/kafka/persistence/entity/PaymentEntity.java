package quick.delivery.paymentservice.infrastructure.adapter.out.kafka.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.PaymentStatus;
import quick.delivery.paymentservice.application.port.command.SavePaymentCommand;
import quick.delivery.paymentservice.infrastructure.adapter.out.kafka.persistence.entity.base.JpaBaseTimeEntity;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@SuperBuilder
@Table(name = "Payment", indexes = {
        @Index(name = "idx_payment_id", columnList = "paymentId", unique = true),
        @Index(name = "idx_saga_id", columnList = "sagaId", unique = true)
})
public class PaymentEntity extends JpaBaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String paymentId;
    @Column(unique = true, nullable = false)
    private String orderId;
    @Column(unique = true, nullable = false)
    private String sagaId;
    @Column(nullable = false)
    private String userId;
    private Long totalPoints;
    private PaymentStatus status;

    public static PaymentEntity convertSaveEntity(SavePaymentCommand command) {
        return PaymentEntity.builder()
                .paymentId(UUID.randomUUID().toString())
                .orderId(command.orderId())
                .sagaId(command.sagaId())
                .userId(command.userId())
                .totalPoints(command.totalPoints())
                .status(command.status())
                .build();
    }
}
