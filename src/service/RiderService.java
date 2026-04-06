package service;

import model.Rider;

import java.util.HashMap;
import java.util.Map;

public class RiderService {

    private Map<Long, Rider> riders = new HashMap<>();

    public Rider registerRider(String name, String location) {
        Rider rider = new Rider(name, location);
        riders.put(rider.getId(), rider);
        return rider;
    }

    public Rider getRiderById(long id) {
        if (!riders.containsKey(id)) {
            throw new RuntimeException("Rider not found");
        }
        return riders.get(id);
    }
}
