package quick.delivery.orderservice.infrastructure.adapter.in.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import quick.delivery.annotation.WebAdapter;
import quick.delivery.common.Supports.ResultCode;
import quick.delivery.orderservice.application.port.command.CreateOrderCommand;
import quick.delivery.orderservice.application.port.in.CreateOrderUseCase;
import quick.delivery.orderservice.application.port.response.CreateOrderResponse;
import quick.delivery.orderservice.infrastructure.adapter.in.web.payload.request.CreateOrderRequest;
import quick.delivery.response.CommonResponse;

@WebAdapter
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderWebAdapter {
   private final CreateOrderUseCase createOrderUseCase;

    @Operation(summary = "주문 생성")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse<CreateOrderResponse> createOrder(
            @Valid
            @org.springframework.web.bind.annotation.RequestBody
            @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(
                                    name = "createOrderExample",
                                    value = """
                                            {
                                              "userId": "test",
                                              "storeMessage": "주문 메시지",
                                              "deliveryAddress": "서울시 성동구 금호동",
                                              "deliveryMessage": "빨리 가져다주세요",
                                              "totalPoints": 1000,
                                              "orderItems": [
                                                {
                                                  "menuId": 1,
                                                  "price": 3000,
                                                  "count": 1
                                                }
                                              ]
                                            }
                                            """
                            )
                    )
            )
            CreateOrderRequest req
    ) {
        CreateOrderCommand command = req.toCommand();
        CreateOrderResponse res = createOrderUseCase.createOrder(command);

        return CommonResponse.<CreateOrderResponse>builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getInfoMessage())
                .data(res)
                .build();
    }
}
