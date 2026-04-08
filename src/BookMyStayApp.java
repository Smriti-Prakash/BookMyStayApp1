/**
 * ===============================================================
 * MAIN CLASS - BookMyStayApp
 * ===============================================================
 * Use Case 3: Centralized Room Inventory Management
 *
 * @version 3.1
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status\n");

        // Room objects (domain)
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Centralized Inventory
        RoomInventory inventory = new RoomInventory();

        // Display Single Room
        System.out.println("Single Room:");
        singleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Single"));

        System.out.println();

        // Display Double Room
        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Double"));

        System.out.println();

        // Display Suite Room
        System.out.println("Suite Room:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Suite"));
    }
}