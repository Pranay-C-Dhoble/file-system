package filehandling.compare;

import java.math.BigDecimal;
import java.util.List;

public class ComparePrice {
    public double getHighestPrice(List data) {
        BigDecimal maxPrice = new BigDecimal(0);
        for(Object d : data){
            String[] data2 = d.toString().split(",");
            String data3 = data2[5];
            BigDecimal currentPrice = new BigDecimal(data3);
            if (currentPrice.compareTo(maxPrice) > 0) {
                maxPrice = currentPrice;
            }
        }
        System.out.println(maxPrice);
        return maxPrice.doubleValue();
    }

//    public static double getLowestPrice(List data){
//        return 0.0;
//    }
}
