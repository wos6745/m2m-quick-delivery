package quick.delivery.orchestratorservice.application.port.out;

import quick.delivery.orchestratorservice.common.dto.SaveSagaInstanceDto;
import quick.delivery.orchestratorservice.common.result.SaveSagaInstanceResult;

public interface SagaInstancePort {
    SaveSagaInstanceResult save(SaveSagaInstanceDto dto);
}
