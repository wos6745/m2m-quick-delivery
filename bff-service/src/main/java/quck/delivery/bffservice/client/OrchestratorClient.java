package quck.delivery.bffservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import quick.delivery.dto.request.BffCreateOrderRequest;
import quick.delivery.response.SagaResponse;

@FeignClient(name = "orchestrator-client", url = "http://localhost:8082")
public interface OrchestratorClient {

    @PostMapping("/api/v1/saga/order")
    SagaResponse startOrderSaga(@RequestBody BffCreateOrderRequest request);

}
