package service;

import model.Driver;

import java.util.*;

public class DriverService {

    private Map<Long, Driver> drivers = new HashMap<>();

    public Driver registerDriver(String name, String location) {
        Driver driver = new Driver(name, location, true);
        drivers.put(driver.getId(), driver);
        return driver;
    }

    public List<Driver> getAvailableDrivers() {
        List<Driver> availableDrivers = new ArrayList<>();

        for (Driver driver : drivers.values()) {
            if (driver.isAvailable()) {
                availableDrivers.add(driver);
            }
        }
        return availableDrivers;
    }

    public void updateAvailability(long driverId, boolean available) {
        Driver driver = drivers.get(driverId);

        if (driver == null) {
            throw new RuntimeException("Driver not found");
        }

        driver.setAvailable(available);
    }

    public Driver getDriverById(long id) {
        if (!drivers.containsKey(id)) {
            throw new RuntimeException("Driver not found");
        }
        return drivers.get(id);
    }
}
