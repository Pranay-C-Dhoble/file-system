package house_price_data_sheet;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Home {
    private int squareFeet;
    private int bedrooms;
    private int bathrooms;
    private String neighbourhood;
    private int year;
    private double price;

}
