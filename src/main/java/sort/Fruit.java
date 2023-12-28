package sort;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fruit implements Comparable{
    private int quantity;
    private String name;
    private String description;

    @Override
    public int compareTo(Object o) {
        Fruit fruit = (Fruit) o;
        return this.name.compareTo(fruit.name);
    }
}
