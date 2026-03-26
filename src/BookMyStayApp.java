import java.util.HashMap;
import java.util.Map;

class RoomInventory{
    private Map<String, Integer> roomAvailability;
    public RoomInventory(){
        roomAvailability = new HashMap<>();
        initializeInventory();
    }
    private void initializeInventory(){
        roomAvailability.put("Single Room", 5);
        roomAvailability.put("Double Room", 3);
        roomAvailability.put("Suite Room", 2);
    }
    public Map<String, Integer> getRoomAvailability(){
        return roomAvailability;
    }
    public void updateAvailability(String roomType, int count){
        roomAvailability.put(roomType, count);
    }
}
public class BookMyStayApp {
    public static void main(String[] args){
        System.out.println("Hotel Room Inventory Status");
        RoomInventory ri = new RoomInventory();
        Map<String, Integer> rooms = ri.getRoomAvailability();
        for(String roomType : rooms.keySet()) {
            System.out.println("\n" + roomType + ";");
            System.out.println("Available: " + rooms.get(roomType));
        }
    }
}

