package app;

public class RegularUser extends User{
    private String location;
    public RegularUser(String username, String password, String location) {
        super(username, password);
        this.location = location;
    }
}
