package yogaClassReservation;

import yogaClassReservation.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserveCanceled_RequestPaymentCancel(@Payload ReserveCanceled reserveCanceled){

        if(reserveCanceled.isMe()){
            System.out.println("##### listener RequestPaymentCancel : " + reserveCanceled.toJson());

            List<Payment> paymentList = paymentRepository.findByReserveId(reserveCanceled.getReserveId());

            for(Payment payment : paymentList)
            {
                payment.setId(reserveCanceled.getId());
                payment.setReserveId(reserveCanceled.getReserveId());
                payment.setPrice(reserveCanceled.getPrice());
                payment.setUserId(reserveCanceled.getUserId());
                payment.setGuestAddress(reserveCanceled.getGuestAddress());
                payment.setPaymentStatus("PayCanceled");

                paymentRepository.save(payment);

                PaymentCanceled paymentCanceled = new PaymentCanceled();
                paymentCanceled.setId(payment.getId());
                paymentCanceled.setReserveId(payment.getReserveId());
                paymentCanceled.setPaymentStatus("PayCanceled");
                paymentCanceled.setGuestAddress(payment.getGuestAddress());
                paymentCanceled.setPrice(payment.getPrice());
                paymentCanceled.setUserId(payment.getUserId());
                paymentCanceled.setPaymentStatus("PayCanceled");

                paymentCanceled.publish();
            }
        }
    }
}
