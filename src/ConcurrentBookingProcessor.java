/**
 * ===============================================================
 * CLASS - ConcurrentBookingProcessor
 * ===============================================================
 * Use Case 11: Concurrent Booking Simulation
 *
 * @version 11.0
 */
public class ConcurrentBookingProcessor implements Runnable {

    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService
    ) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {

        while (true) {

            Reservation reservation;

            // 🔒 Critical Section 1: Queue access
            synchronized (bookingQueue) {

                if (!bookingQueue.hasPendingRequests()) {
                    break; // stop thread when queue empty
                }

                reservation = bookingQueue.getNextRequest();
            }

            // 🔒 Critical Section 2: Inventory + Allocation
            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}