package quick.delivery.orchestratorservice.application.port.in;

import quick.delivery.dto.request.BffCreateOrderRequest;

public interface SagaStartService {
    Long initiateOrderSaga(BffCreateOrderRequest req);
}
