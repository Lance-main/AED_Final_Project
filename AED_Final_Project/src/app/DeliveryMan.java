package app;
import java.util.ArrayList;

public class DeliveryMan extends User{
    private ArrayList<Delivery> deliveries;
    public DeliveryMan(String username, String password) {
        super(username, password);
        deliveries = new ArrayList<>();
    }

    public void addDelivery(String start, String finish){
        //adding a location check
        deliveries.add(new Delivery(start,finish));
    }
}
