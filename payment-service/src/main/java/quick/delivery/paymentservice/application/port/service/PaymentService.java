package quick.delivery.paymentservice.application.port.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quick.delivery.common.Supports;
import quick.delivery.exception.CreatePaymentException;
import quick.delivery.message.reply.payment.PaymentCommandReply;
import quick.delivery.paymentservice.application.port.command.CreatePaymentCommand;
import quick.delivery.paymentservice.application.port.command.SavePaymentCommand;
import quick.delivery.paymentservice.application.port.in.CreatePaymentUseCase;
import quick.delivery.paymentservice.application.port.out.PaymentCommandPort;
import quick.delivery.paymentservice.application.port.out.PaymentEventPort;
import quick.delivery.paymentservice.application.port.response.SavePaymentResponse;
import quick.delivery.paymentservice.domain.Payment;
import tools.jackson.databind.ObjectMapper;

import static quick.delivery.common.Supports.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class PaymentService implements CreatePaymentUseCase {
    private final PaymentCommandPort paymentCommandPort;
    private final PaymentEventPort paymentEventPort;
    private final ObjectMapper objectMapper;
    @Override
    public void createPayment(CreatePaymentCommand command) {
        Payment payment = Payment.builder()
                .sagaId(command.sagaId())
                .userId(command.userId())
                .orderId(command.orderId())
                .totalPoints(command.totalPoints())
                .status(command.status())
                .build();

        payment.validateCreatePayment();

        SavePaymentCommand savePaymentCommand = command.toSaveCommand();
        SavePaymentResponse savePaymentResponse = paymentCommandPort.savePayment(savePaymentCommand);

        if (!savePaymentResponse.isSuccess()) {
            String jsonString = objectMapper.writeValueAsString(savePaymentCommand);
            throw new CreatePaymentException(PAYMENT_ENTITY_SAVE_FAIL, jsonString);
        }

        PaymentCommandReply reply = PaymentCommandReply.builder()
                .paymentId(savePaymentResponse.paymentId())
                .build();

        paymentEventPort.sendPaymentCreatedEvent(reply);
    }
}
