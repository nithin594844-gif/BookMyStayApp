import java.util.*;

class Reservation {
    private String guestName;
    private String roomType;
    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
    public String getGuestName() {
        return guestName;
    }
    public String getRoomType() {
        return roomType;
    }
}
class RoomInventory {
    private Map<String, Integer> roomAvailability;
    public RoomInventory() {
        roomAvailability = new HashMap<>();
        roomAvailability.put("Single", 2);
        roomAvailability.put("Double", 2);
        roomAvailability.put("Suite", 1);
    }
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }
    public void updateAvailability(String type, int count) {
        roomAvailability.put(type, count);
    }
}
class RoomAllocationService {
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomByType;
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomByType = new HashMap<>();
    }
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();
        if (availability.get(roomType) > 0) {
            String roomId = generateRoomId(roomType);
            allocatedRoomIds.add(roomId);
            assignedRoomByType.computeIfAbsent(roomType, k -> new HashSet<>()).add(roomId);
            inventory.updateAvailability(roomType, availability.get(roomType) - 1);
            System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() + ", Room ID: " + roomId);
        }
        else {
            System.out.println("No rooms available for: " + roomType);
        }
    }
    private String generateRoomId(String roomType) {
        String prefix = roomType.substring(0, 1).toUpperCase();
        String roomId;
        do {
            roomId = prefix + (100 + (int)(Math.random() * 900));
        } while (allocatedRoomIds.contains(roomId));
        return roomId;
    }
}
class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Room Allocation Processing\n");
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService service = new RoomAllocationService();
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");
        service.allocateRoom(r1, inventory);
        System.out.println();
        service.allocateRoom(r2, inventory);
        System.out.println();
        service.allocateRoom(r3, inventory);
        System.out.println();
    }
}