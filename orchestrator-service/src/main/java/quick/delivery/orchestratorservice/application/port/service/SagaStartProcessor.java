package quick.delivery.orchestratorservice.application.port.service;

import org.springframework.stereotype.Service;
import quick.delivery.common.Supports.*;
import quick.delivery.dto.request.BffCreateOrderRequest;
import quick.delivery.orchestratorservice.application.port.in.SagaStartService;
import quick.delivery.orchestratorservice.common.dto.SaveSagaInstanceDto;

@Service
public class SagaStartProcessor implements SagaStartService {

    @Override
    public Long initiateOrderSaga(BffCreateOrderRequest req) {

        SaveSagaInstanceDto dto = SaveSagaInstanceDto.builder()
                .sagaStatus(SagaProcessStatus.INITIATED)
                .orderId(0L)
                .build();

        return null;
    }
}
