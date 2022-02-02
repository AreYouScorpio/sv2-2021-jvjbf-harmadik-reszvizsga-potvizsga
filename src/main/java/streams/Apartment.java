package streams;

import java.util.List;

public class Apartment {
    private String location;
    private int size;
    public BathRoomType bathRoomType;

    private List<String> extras;

    public String getLocation() {
        return location;
    }

    public int getSize() {
        return size;
    }

    public List<String> getExtras() {
        return extras;
    }

    public BathRoomType getBathRoomType() {
        return bathRoomType;
    }

    public Apartment(String location, int size, BathRoomType bathRoomType, List<String> extras) {
        this.location = location;
        this.size = size;
        this.bathRoomType = bathRoomType;
        this.extras = extras;
    }


}
