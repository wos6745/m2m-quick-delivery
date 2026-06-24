package quick.delivery.paymentservice.infrastructure.adapter.out.kafka.persistence;

import lombok.RequiredArgsConstructor;
import quick.delivery.annotation.PersistenceAdapter;
import quick.delivery.paymentservice.application.port.command.SavePaymentCommand;
import quick.delivery.paymentservice.application.port.out.PaymentCommandPort;
import quick.delivery.paymentservice.application.port.response.SavePaymentResponse;
import quick.delivery.paymentservice.infrastructure.adapter.out.kafka.persistence.entity.PaymentEntity;
import quick.delivery.paymentservice.infrastructure.adapter.out.kafka.persistence.jpa.PaymentJpaRepository;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemoryPaymentPersistenceAdapter implements PaymentCommandPort {
    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public SavePaymentResponse savePayment(SavePaymentCommand command) {
        PaymentEntity paymentEntity = PaymentEntity.convertSaveEntity(command);
        PaymentEntity result = paymentJpaRepository.save(paymentEntity);

        return SavePaymentResponse.builder()
                .isSuccess(true)
                .paymentId(result.getPaymentId())
                .build();
    }
}
