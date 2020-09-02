package yogaClassReservation;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Payment_table")
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long reserveId;
    private Long price;
    private Long userId;
    private String paymentStatus;
    private String guestAddress;

    @PostPersist
    public void onPostPersist(){

        if("PaymentRequest".equals(getPaymentStatus())) {
            PaymentSucceed paymentSucceed = new PaymentSucceed();
            BeanUtils.copyProperties(this, paymentSucceed);
            paymentSucceed.setPaymentStatus(getPaymentStatus());


            paymentSucceed.publishAfterCommit();

            // 결제이력을 저장한 후 적당한 시간 끌기
            /*
            try {
                Thread.currentThread().sleep((long) (400 + Math.random() * 220));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
        }
    }

//    @PreRemove
//    public void onPreRemove(){
//        PaymentCanceled paymentCanceled = new PaymentCanceled();
//        BeanUtils.copyProperties(this, paymentCanceled);
//        paymentCanceled.setPaymentStatus("PaymentCanceled");
//        paymentCanceled.publishAfterCommit();
//
//
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getReserveId() {
        return reserveId;
    }

    public void setReserveId(Long reserveId) {
        this.reserveId = reserveId;
    }
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public String getGuestAddress() {
        return guestAddress;
    }

    public void setGuestAddress(String guestAddress) {
        this.guestAddress = guestAddress;
    }




}
