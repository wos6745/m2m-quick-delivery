package quick.delivery.orchestratorservice.application.port.out;

import quick.delivery.orchestratorservice.common.dto.SaveSagaInstanceDto;
import quick.delivery.orchestratorservice.common.dto.UpdateSagaInstanceStatusDto;
import quick.delivery.orchestratorservice.common.result.SaveSagaInstanceResult;
import quick.delivery.orchestratorservice.common.result.UpdateSagaInstanceStatusResult;

public interface SagaInstancePort {
    SaveSagaInstanceResult save(SaveSagaInstanceDto dto);
    UpdateSagaInstanceStatusResult updateSagaStatus(UpdateSagaInstanceStatusDto dto);
}
