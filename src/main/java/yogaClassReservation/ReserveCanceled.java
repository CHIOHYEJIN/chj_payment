package yogaClassReservation;

public class ReserveCanceled extends AbstractEvent {

    private Long id;
    private Long reserveId;
    private Long userId;
    private Long price;
    private String reservationStatus;
    private String guestAddress;
    private Long classId;

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
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
    public String getGuestAddress() {
        return guestAddress;
    }

    public void setGuestAddress(String guestAddress) {
        this.guestAddress = guestAddress;
    }
    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
}