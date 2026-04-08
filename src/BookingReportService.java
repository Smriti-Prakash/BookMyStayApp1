/**
 * ===============================================================
 * CLASS - BookingReportService
 * ===============================================================
 * Use Case 8: Booking History & Reporting
 *
 * @version 8.0
 */
public class BookingReportService {

    public void generateReport(BookingHistory history) {

        System.out.println("Booking History Report\n");

        for (Reservation reservation : history.getConfirmedReservations()) {

            System.out.println(
                    "Guest: " + reservation.getGuestName() +
                            ", Room Type: " + reservation.getRoomType()
            );
        }
    }
}