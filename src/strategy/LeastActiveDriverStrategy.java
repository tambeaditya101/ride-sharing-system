package strategy;

import model.Driver;
import model.Rider;

import java.util.List;

public class LeastActiveDriverStrategy implements RideMatchingStrategy {

    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers) {

        Driver selected = null;

        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                if (selected == null || driver.getTotalRides() < selected.getTotalRides()) {
                    selected = driver;
                }
            }
        }

        return selected;
    }
}