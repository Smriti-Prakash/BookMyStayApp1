/**
 * ===============================================================
 * MAIN CLASS - BookMyStayApp
 * ===============================================================
 * Use Case 11: Concurrent Booking Simulation
 *
 * @version 11.0
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation\n");

        // Shared resources
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomAllocationService allocationService = new RoomAllocationService();

        // Add booking requests
        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Double"));
        bookingQueue.addRequest(new Reservation("Kural", "Suite"));
        bookingQueue.addRequest(new Reservation("Subha", "Single"));

        // Create threads
        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(
                        bookingQueue, inventory, allocationService
                )
        );

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(
                        bookingQueue, inventory, allocationService
                )
        );

        // Start threads
        t1.start();
        t2.start();

        // Wait for completion
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        // Display remaining inventory
        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + inventory.getRoomAvailability().get("Single"));
        System.out.println("Double: " + inventory.getRoomAvailability().get("Double"));
        System.out.println("Suite: " + inventory.getRoomAvailability().get("Suite"));
    }
}