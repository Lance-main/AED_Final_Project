package app;
import java.util.ArrayList;

public class Administrator extends Manager{
    private ArrayList<Organization> organizations;
    private ArrayList<Enterprise> enterprises;
    private ArrayList<User> users;
    private ArrayList<Delivery> deliveries;

    public Administrator(String username, String password, String database) {
        super(username, password);
        organizations = new ArrayList<>();
        enterprises = new ArrayList<>();
        users = new ArrayList<>();
        deliveries = new ArrayList<>();
        fill(database);
    }

    @Override
    void manage() {

    }

    public void fill(String database){

    }
}
