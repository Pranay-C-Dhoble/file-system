package filehandling.processor;

import filehandling.model.House;

import java.util.List;
import java.util.stream.Collectors;

public class BedRoomProcessor {
    public static List<House> getHouses(List<House> list, int bedroomSize) {
        return list.stream().filter(h -> h.getBedrooms() == bedroomSize).collect(Collectors.toList());
    }
}
