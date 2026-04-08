/**
 * ===============================================================
 * MAIN CLASS - BookMyStayApp
 * ===============================================================
 * Use Case 12: Data Persistence & Recovery
 *
 * @version 12.0
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("System Recovery\n");

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();

        String filePath = "inventory.txt";

        // Load previous state
        persistenceService.loadInventory(inventory, filePath);

        // Display current inventory
        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.getRoomAvailability().get("Single"));
        System.out.println("Double: " + inventory.getRoomAvailability().get("Double"));
        System.out.println("Suite: " + inventory.getRoomAvailability().get("Suite"));

        // Save state (simulate shutdown)
        persistenceService.saveInventory(inventory, filePath);
    }
}