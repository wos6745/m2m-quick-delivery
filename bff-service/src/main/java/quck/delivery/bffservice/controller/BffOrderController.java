package quck.delivery.bffservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import quck.delivery.bffservice.client.OrchestratorClient;
import quck.delivery.bffservice.payload.BffCreateOrderResponse;
import quick.delivery.common.Supports;
import quick.delivery.dto.request.BffCreateOrderRequest;
import quick.delivery.response.CommonResponse;
import quick.delivery.response.SagaResponse;

import static quick.delivery.common.Supports.ResultCode.*;

@RestController
@RequiredArgsConstructor
public class BffOrderController {
    private final OrchestratorClient orchestratorClient;

    @PostMapping("/bff/orders")
    public CommonResponse<SagaResponse> createOrder(@RequestBody BffCreateOrderRequest req) {
        SagaResponse sagaResponse = orchestratorClient.startOrderSaga(req);

        return CommonResponse.<SagaResponse>builder()
                .code(SUCCESS.getCode())
                .message(SUCCESS.getInfoMessage())
                .data(sagaResponse)
                .build();
    }
}
