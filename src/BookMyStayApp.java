/**
 * ===============================================================
 * MAIN CLASS - BookMyStayApp
 * ===============================================================
 * Use Case 8: Booking History & Reporting
 *
 * @version 8.0
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Booking History and Reporting\n");

        // Booking history
        BookingHistory history = new BookingHistory();

        // Simulating confirmed bookings (from UC6)
        history.addReservation(new Reservation("Abhi", "Single"));
        history.addReservation(new Reservation("Subha", "Double"));
        history.addReservation(new Reservation("Vanmathi", "Suite"));

        // Report service
        BookingReportService reportService = new BookingReportService();

        // Generate report
        reportService.generateReport(history);
    }
}