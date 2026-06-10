package quick.delivery.orderservice.infrastructure.adapter.out.persistence.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JpaBaseTimeEntity {
    @Column(updatable = false)
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

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
