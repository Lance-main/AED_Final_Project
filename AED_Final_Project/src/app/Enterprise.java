package app;
import java.security.InvalidParameterException;

public class Enterprise {
    private String name;

    private String location;
    private int rating;
    private final Organization[] orgs;

    public Enterprise(Organization org1,Organization org2, int rating, String name){
        orgs = new Organization[]{org1 , org2};
        if(rating<0 || rating>10){
            throw new InvalidParameterException("Please enter a rating between 1 and 10");
        }
        else {
            this.rating = rating;
            this.name = name;
        }
        locate(name);
    }

    public void locate(String name) throws IllegalArgumentException{
        //Google Maps API will attempt to locate, if no country
        //with such name is found throw IllegalArgumentException
    }
}
