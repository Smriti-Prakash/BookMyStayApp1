import java.util.*;

/**
 * ===============================================================
 * CLASS - RoomAllocationService
 * ===============================================================
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * @version 6.0
 */
public class RoomAllocationService {

    // Stores ALL allocated room IDs (global uniqueness)
    private Set<String> allocatedRoomIds;

    // Stores allocated IDs per room type
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Allocates a room if available
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // Check availability
        if (availability.getOrDefault(roomType, 0) <= 0) {
            System.out.println("Booking failed for Guest: "
                    + reservation.getGuestName()
                    + " (No rooms available for " + roomType + ")");
            return;
        }

        // Generate unique room ID
        String roomId = generateRoomId(roomType);

        // Store globally
        allocatedRoomIds.add(roomId);

        // Store per type
        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        // Update inventory (CRITICAL)
        inventory.updateAvailability(roomType, availability.get(roomType) - 1);

        // Confirm booking
        System.out.println("Booking confirmed for Guest: "
                + reservation.getGuestName()
                + ", Room ID: " + roomId);
    }

    /**
     * Generates unique room ID
     */
    private String generateRoomId(String roomType) {

        int count = assignedRoomsByType
                .getOrDefault(roomType, new HashSet<>())
                .size() + 1;

        return roomType + "-" + count;
    }
}