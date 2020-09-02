package yogaClassReservation;

public class PaymentSucceed extends AbstractEvent {

    private Long id;
    private Long reserveId;
    private Long price;
    private Long userId;
    private String paymentStatus;
    private String guestAddress;

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