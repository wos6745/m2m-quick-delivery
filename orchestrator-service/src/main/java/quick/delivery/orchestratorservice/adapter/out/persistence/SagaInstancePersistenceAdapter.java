package quick.delivery.orchestratorservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import quick.delivery.annotation.PersistenceAdapter;
import quick.delivery.orchestratorservice.application.port.out.SagaInstancePort;

@PersistenceAdapter
@RequiredArgsConstructor
public class SagaInstancePersistenceAdapter implements SagaInstancePort {
}
