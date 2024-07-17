package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        System.out.println(buildApartmentsList(apartments, 3));
    }

    public static List<Home> buildApartmentsList(List<Home> apartmentsList, int count) {
        List<Home> result = new ArrayList<>(apartmentsList);
        result.sort(Comparator.comparing(Home::getArea));
        return result.stream().limit(count).collect(Collectors.toList());
    }
}
// END
