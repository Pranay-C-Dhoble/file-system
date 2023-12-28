package file_handling.processor;

import file_handling.model.House;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BedRoomProcessor {
    public static List<House> getHouses(List<House> list, int bedroomSize) {
        return list.stream().filter(h -> h.getBedrooms() == bedroomSize).collect(Collectors.toList());
    }
}
