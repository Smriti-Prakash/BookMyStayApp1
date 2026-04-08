/**
 * ===============================================================
 * MAIN CLASS - BookMyStayApp
 * ===============================================================
 * Use Case 4: Room Search & Availability Check
 *
 * @version 4.0
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Room Search\n");

        // Domain objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Search service
        RoomSearchService searchService = new RoomSearchService();

        // Perform search (READ ONLY)
        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}