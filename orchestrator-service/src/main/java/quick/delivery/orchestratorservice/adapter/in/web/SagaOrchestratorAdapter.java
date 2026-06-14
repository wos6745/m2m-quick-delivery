package quick.delivery.orchestratorservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import quick.delivery.annotation.WebAdapter;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.SagaStatus.*;
import quick.delivery.dto.request.BffCreateOrderRequest;
import quick.delivery.orchestratorservice.application.port.in.SagaStartService;
import quick.delivery.response.SagaResponse;

import static quick.delivery.common.Supports.SagaStatus.*;

@WebAdapter
@RequiredArgsConstructor
@RequestMapping("/api/v1/saga")
public class SagaOrchestratorAdapter {
    private final SagaStartService sagaStartService;

    @PostMapping("/order")
    public SagaResponse startOrderSaga(@RequestBody BffCreateOrderRequest req) {
        Long sagaId = sagaStartService.initiateOrderSaga(req);

        return SagaResponse
                .builder()
                .sagaId(sagaId)
                .sagaStatus(INITIATED.getCode())
                .sagaMessage(INITIATED.getInfoMessage())
                .build();
    }
}
