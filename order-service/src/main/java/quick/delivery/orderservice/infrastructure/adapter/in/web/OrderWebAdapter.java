package quick.delivery.orderservice.infrastructure.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import quick.delivery.orderservice.domain.Order;
import quick.delivery.response.CommonResponse;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderWebAdapter {

    @PostMapping
    public CommonResponse<String> createOrder() {
        return CommonResponse.<String>builder().build();
    }
}
