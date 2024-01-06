package filehandling.metrics;

import filehandling.model.BedRoomCount;
import filehandling.model.House;
import filehandling.model.NeighbourhoodCount;
import filehandling.writer.jsonwrite.JsonFileWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BedRoomNeighbourhoodMatric implements MetricCollector{
    @Override
    public void collect(List<House> data) {
        Map<Integer,List<House>> groupByBedRoom = data.stream().collect(Collectors.groupingBy(House::getBedrooms));

        groupByBedRoom.forEach((bhk, records) -> {
            Map<String, List<House>> bhkNebours = records.stream().collect(Collectors.groupingBy(House::getNeighbourhood));
            System.out.print(bhk + " BHK:" + records.size());
            bhkNebours.forEach((k,v) -> System.out.print("["+ k+":"+ v.size()+"],"));
            System.out.println();
        });

        // data
        // bedrooms
        // neighbourhoods

        // 1) Build Objects
        // 2) Write Objects to JSON

        Map<Integer, NeighbourhoodCount> countData = new HashMap<>();
        groupByBedRoom.forEach((bhk, records) -> {
            Map<String, List<House>> bhkNebours = records.stream().collect(Collectors.groupingBy(House::getNeighbourhood));
            System.out.print(" " + bhk + " BHK:" + records.size());
            final NeighbourhoodCount neighbourhoodCount = NeighbourhoodCount.builder().total(records.size()).build();
            //here builer is used to build the object
            bhkNebours.entrySet().forEach((entry) -> { //entrySet is used to get the key and value
                setValues(entry, neighbourhoodCount);
            });
            countData.put(bhk, neighbourhoodCount);
        });

        BedRoomCount bedroomsCount = BedRoomCount.builder().bedrooms(countData).build();
        JsonFileWriter.write(bedroomsCount);

    }

    private void setValues(Map.Entry<String, List<House>> entry, NeighbourhoodCount neighbourhoodCount) {
        if("Rural".equals(entry.getKey())){
            neighbourhoodCount.setRural(entry.getValue().size());
        } else if("Suburb".equals(entry.getKey())){
            neighbourhoodCount.setSuburb(entry.getValue().size());
        } else if("Urban".equals(entry.getKey())){
            neighbourhoodCount.setUrban(entry.getValue().size());
        }
    }
}
