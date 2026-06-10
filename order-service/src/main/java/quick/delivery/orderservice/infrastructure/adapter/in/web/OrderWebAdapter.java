package quick.delivery.orderservice.infrastructure.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import quick.delivery.annotation.WebAdapter;
import quick.delivery.common.Supports;
import quick.delivery.common.Supports.ResultCode;
import quick.delivery.orderservice.application.port.command.CreateOrderCommand;
import quick.delivery.orderservice.application.port.in.CreateOrderUseCase;
import quick.delivery.orderservice.application.port.response.CreateOrderResponse;
import quick.delivery.orderservice.domain.Order;
import quick.delivery.orderservice.infrastructure.adapter.in.web.payload.request.CreateOrderRequest;
import quick.delivery.response.CommonResponse;

@WebAdapter
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderWebAdapter {
   private final CreateOrderUseCase createOrderUseCase;

    @PostMapping
    public CommonResponse<CreateOrderResponse> createOrder(CreateOrderRequest req) {
        CreateOrderCommand command = req.toCommand();
        CreateOrderResponse res = createOrderUseCase.createOrder(command);

        return CommonResponse.<CreateOrderResponse>builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getInfoMessage())
                .data(res)
                .build();
    }
}
