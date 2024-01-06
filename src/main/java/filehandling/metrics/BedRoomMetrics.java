package filehandling.metrics;

import filehandling.model.House;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BedRoomMetrics implements MetricCollector {
    @Override
    public void collect(List<House> data) {
        Map<Integer,List<House>> housesByBedRoom = data.stream().collect(Collectors.groupingBy(House::getBedrooms));
        housesByBedRoom.forEach((key,value) -> System.out.println("Number of houses with " + key + " bedrooms are " + value.size()));
    }
}
