package file_handling.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class House {
    private int squareFeet;
    private int bedrooms;
    private int bathrooms;
    private String neighbourhood;
    private int year;
    private double price;

    @Override
    public String toString() {
        return  squareFeet +
                "," + bedrooms +
                "," + bathrooms +
                "," + neighbourhood +
                "," + year +
                "," + price;
    }
}
