package app;
public abstract class Donation {
    protected User donator;

    public Donation(User donator){
        this.donator = donator;
    }
}
