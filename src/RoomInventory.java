import java.util.HashMap;
import java.util.Map;

/**
 * ===============================================================
 * CLASS - RoomInventory
 * ===============================================================
 * Use Case 3: Centralized Room Inventory Management
 *
 * Acts as single source of truth for room availability.
 *
 * @version 3.1
 */
public class RoomInventory {

    // Key -> Room type | Value -> Available count
    private Map<String, Integer> roomAvailability;

    // Constructor
    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    // Initialize default values
    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    // Get full availability map
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    // Update availability
    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}