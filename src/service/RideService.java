package service;

import model.*;
import strategy.FareStrategy;
import strategy.RideMatchingStrategy;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.*;

public class RideService {

    private Map<Long, Ride> rides = new HashMap<>();

    private RideMatchingStrategy matchingStrategy;
    private FareStrategy fareStrategy;
    private DriverService driverService;
    private RiderService riderService;

    public RideService(RideMatchingStrategy matchingStrategy,
                       FareStrategy fareStrategy,
                       DriverService driverService,
                       RiderService riderService) {
        this.matchingStrategy = matchingStrategy;
        this.fareStrategy = fareStrategy;
        this.driverService = driverService;
        this.riderService = riderService;
    }

    public Ride requestRide(long riderId, double distance) {

        // 1. Get Rider
        Rider rider = riderService.getRiderById(riderId);

        // 2. Get available drivers
        List<Driver> drivers = driverService.getAvailableDrivers();

        // 3. Find driver using strategy
        Driver driver = matchingStrategy.findDriver(rider, drivers);

        if (driver == null) {
            throw new RuntimeException("No drivers available");
        }

        // 4. Create Ride
        Ride ride = new Ride(rider, driver, distance);

        // 5. Mark driver unavailable
        driverService.updateAvailability(driver.getId(), false);

        // 6. Calculate fare
        double fare = fareStrategy.calculateFare(ride);

        // 7. Attach FareReceipt
        FareReciept receipt = new FareReciept(ride.getId(), fare, LocalDateTime.now() );
        ride.setFareReciept(receipt);

        // 8. Update status
        ride.setStatus(RideStatus.ONGOING);

        // 9. Store ride
        rides.put(ride.getId(), ride);

        return ride;
    }

    public void completeRide(long rideId) {

        Ride ride = rides.get(rideId);

        if (ride == null) {
            throw new RuntimeException("Ride not found");
        }

        // 1. Update status
        ride.setStatus(RideStatus.COMPLETED);

        // 2. Free driver
        Driver driver = ride.getDriver();
        driverService.updateAvailability(driver.getId(), true);
    }

    public List<Ride> getAllRides() {
        return new ArrayList<>(rides.values());
    }

}