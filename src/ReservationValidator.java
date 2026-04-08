/**
 * ===============================================================
 * CLASS - ReservationValidator
 * ===============================================================
 * Use Case 9: Error Handling & Validation
 *
 * @version 9.0
 */
public class ReservationValidator {

    public void validate(
            String guestName,
            String roomType,
            RoomInventory inventory
    ) throws InvalidBookingException {

        // 1. Validate guest name
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // 2. Validate room type (STRICT CASE-SENSITIVE)
        if (!roomType.equals("Single") &&
                !roomType.equals("Double") &&
                !roomType.equals("Suite")) {

            throw new InvalidBookingException("Invalid room type selected.");
        }

        // 3. Validate availability
        int available = inventory.getRoomAvailability()
                .getOrDefault(roomType, 0);

        if (available <= 0) {
            throw new InvalidBookingException(
                    "No rooms available for selected type."
            );
        }
    }
}