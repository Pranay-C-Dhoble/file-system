package file_handling.processor;

import file_handling.model.House;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BedRoomProcessor {
    public List<House> getHouses(List<House> houses, int bedroomSize) {
        List<House> bhkList = houses.stream().filter(h -> h.getBedrooms() == bedroomSize).collect(Collectors.toList());
        return bhkList;
    }
}
