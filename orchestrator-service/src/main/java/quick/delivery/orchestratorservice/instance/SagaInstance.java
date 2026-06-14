package quick.delivery.orchestratorservice.instance;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import quick.delivery.common.Supports.*;

import java.time.LocalDateTime;

public class SagaInstance {
    private Long id;
    private Long orderId;
    private SagaStatus sagaStatus;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    @Builder
    public SagaInstance(Long id, Long orderId, SagaStatus sagaStatus, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.id = id;
        this.orderId = orderId;
        this.sagaStatus = sagaStatus;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }
}
