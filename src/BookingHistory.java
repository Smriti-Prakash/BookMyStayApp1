import java.util.*;

/**
 * ===============================================================
 * CLASS - BookingHistory
 * ===============================================================
 * Use Case 8: Booking History & Reporting
 *
 * @version 8.0
 */
public class BookingHistory {

    private List<Reservation> confirmedReservations;

    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}