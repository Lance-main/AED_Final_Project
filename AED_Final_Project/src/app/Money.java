package app;

public class Money extends Donation{
    private int amount;

    public Money(User user,int amount){
        super(user);
        this.amount = amount;
    }
}
