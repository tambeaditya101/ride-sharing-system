package strategy;

import model.Driver;
import model.Rider;

import java.util.List;

public class LeastActiveDriverStrategy implements RideMatchingStrategy {

    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers) {

        // Dummy logic for now
        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                return driver;
            }
        }

        return null;
    }
}