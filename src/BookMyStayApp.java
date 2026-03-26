abstract class Room {
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;
    public Room (int numberOfBeds,int squareFeet,double pricePerNight){
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }
    public void displayRoomDetails(){
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet);
        System.out.println("Price per night: " + pricePerNight);
    }
}
class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}
class DoubleRoom extends Room {
    public DoubleRoom(){
        super(2,400,2500.0);
    }
}
class SuiteRoom extends Room {
    public SuiteRoom(){
        super(3,750,5000.0);
    }
}
public class BookMyStayApp {
    public static void main(String[] args){
        System.out.println("Hotel Room Initialization");
        int si = 5,dou = 3,su = 2;
        System.out.println("\nSingle Room: ");
        SingleRoom sr = new SingleRoom();
        sr.displayRoomDetails();
        System.out.println("Available: " + si);

        System.out.println("\nDouble Room: ");
        DoubleRoom dr = new DoubleRoom();
        dr.displayRoomDetails();
        System.out.println("Available: " + dou);

        System.out.println("\nSuite Room: ");
        SingleRoom sur = new SingleRoom();
        sur.displayRoomDetails();
        System.out.println("Available: " + su);
    }
}

