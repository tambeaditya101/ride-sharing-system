package strategy;

import model.Driver;
import model.Rider;

import java.util.List;

public class NearestDriverStrategy implements RideMatchingStrategy {

    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers) {

        for (Driver driver : drivers) {
            if (driver.isAvailable() &&
                    driver.getCurrentLocation().equalsIgnoreCase(rider.getLocation())) {
                return driver;
            }
        }

        // fallback
        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                return driver;
            }
        }

        return null;
    }
}