package filehandling.metrics;

import filehandling.model.House;

import java.util.List;

public interface MetricCollector {
    void collect (List<House> data);
}
