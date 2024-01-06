package filehandling.metrics;

import filehandling.model.House;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NeighbourhoodMetrics implements MetricCollector{
    @Override
    public void collect(List<House> data) {
        Map<String,List<House>> groupByNeighbourhood = data.stream().collect(Collectors.groupingBy(House::getNeighbourhood));
        groupByNeighbourhood.forEach((key,value) -> System.out.println("Number of houses with Neighbourhood " + key + " are " + value.size()));
    }
}
