import java.util.HashMap;
import java.util.Map;

class RoomInventory {
    private Map<String, Integer> roomAvailability;
    public RoomInventory() {
        roomAvailability = new HashMap<>();
        roomAvailability.put("Single Room", 5);
        roomAvailability.put("Double Room", 3);
        roomAvailability.put("Suite Room", 2);
    }
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }
}
class RoomSearchService {
    public void searchAvailableRooms(RoomInventory inventory) {
        Map<String, Integer> availability = inventory.getRoomAvailability();
        if (availability.get("Single Room") > 0)
            System.out.println("Single rooms are available");
        if (availability.get("Double Room") > 0)
            System.out.println("Double rooms are available");
        if (availability.get("Suite Room") > 0)
            System.out.println("Suite rooms are available");
    }
}
public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Room Search");
        RoomInventory inventory = new RoomInventory();
        RoomSearchService rss = new RoomSearchService();
        rss.searchAvailableRooms(inventory);
    }
}