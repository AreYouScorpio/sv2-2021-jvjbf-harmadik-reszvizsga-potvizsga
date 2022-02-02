package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ApartmentRental {

    private List<Apartment> apartments = new ArrayList<>();

    public void addApartment(Apartment a) {
        apartments.add(a);
    }

    public List<Apartment> findApartmentByLocation(String location) {
        return apartments.stream().filter(a -> a.getLocation().equals(location)).toList();
    }

    public List<Apartment> findApartmentByExtras(String... extras) {
        List<Apartment> result = apartments;
        for (String s : extras)
            result = result.stream().filter(e -> e.getExtras().contains(s)).collect(Collectors.toList());
        return result;
    }

    ;

    public boolean isThereApartmentWithBathroomType(BathRoomType bathRoomType) {
        return apartments.stream().anyMatch(e -> e.getBathRoomType().equals(bathRoomType));
    }

    public List<Integer> findApartmentsSize() {
        return apartments.stream().mapToInt(e -> e.getSize()).boxed().toList();
    }

}
