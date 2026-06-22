package quick.delivery.orchestratorservice.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.SagaProcessStatus;
import quick.delivery.common.Supports.SagaStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "saga_instance",indexes = {
        @Index(name = "idx_orders_saga_id", columnList = "sagaId")
})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SagaInstanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, columnDefinition = "VARCHAR(36)")
    private String sagaId;
    private Long orderId;
    @Enumerated(EnumType.STRING)
    private SagaProcessStatus sagaStatus;
    @Column(updatable = false)
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;


    @Builder
    public SagaInstanceEntity(String sagaId, Long orderId, SagaProcessStatus sagaStatus) {
        this.sagaId = sagaId;
        this.orderId = orderId;
        this.sagaStatus = sagaStatus;
    }

    public void updateStatusAndOrderId(SagaProcessStatus sagaStatus, Long orderId) {
        this.sagaStatus = sagaStatus;
        this.orderId = orderId;
    }

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.createDateTime = this.updateDateTime = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.updateDateTime = LocalDateTime.now();
    }
}
