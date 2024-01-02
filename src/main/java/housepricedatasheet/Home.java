package housepricedatasheet;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Home implements Comparable {
    private int squareFeet;
    private int bedrooms;
    private int bathrooms;
    private String neighbourhood;
    private int year;
    private double price;


    public int compareTo(Object o) {
        Home home = (Home) o;
        return this.neighbourhood.compareTo(home.neighbourhood);
    }
}
