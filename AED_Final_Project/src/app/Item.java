package app;
public class Item extends Donation{
    private int quantity;
    private Type type;

    public Item(User donator, String type) {
        super(donator);
        this.type = Type.valueOf(type);
    }
}
