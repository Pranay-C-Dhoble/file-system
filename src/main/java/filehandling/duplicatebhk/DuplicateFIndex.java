package filehandling.duplicatebhk;

import filehandling.model.House;

import java.util.List;

public class DuplicateFIndex {
    public static void findDuplicate(List<House> data) {
        data.forEach(d -> {
            long count = duplicateCount(d, data);
            if(count > 2){
                System.out.println(count + ": " + d);
            }
        });
    }

    public static long duplicateCount(House house, List<House> data){
        return data.stream().filter(h -> isDuplicate(house, h)).count();
    }
    public static boolean isDuplicate(House left, House right){
        if(!left.getNeighbourhood().equals(right.getNeighbourhood())){
            return false;
        }
        if(left.getBedrooms() != right.getBedrooms()){
            return false;
        }
        if(left.getBathrooms() != right.getBathrooms()){
            return false;
        }
        if(left.getSquareFeet() != right.getSquareFeet()){
            return false;
        }
        if(left.getYear() != right.getYear()){
            return false;
        }
        return true;
    }
}
