import model.Driver;
import model.Ride;
import model.Rider;
import service.DriverService;
import service.RideService;
import service.RiderService;
import strategy.*;

public class Main {

    public static void main(String[] args) {

        // Initialize Services
        RiderService riderService = new RiderService();
        DriverService driverService = new DriverService();

        // Register Riders
        Rider r1 = riderService.registerRider("Aditya", "Mumbai");
        Rider r2 = riderService.registerRider("Rahul", "Pune");

        // Register Drivers
        Driver d1 = driverService.registerDriver("Driver1", "Mumbai");
        Driver d2 = driverService.registerDriver("Driver2", "Mumbai");
        Driver d3 = driverService.registerDriver("Driver3", "Mumbai");
        Driver d4 = driverService.registerDriver("Driver4", "Mumbai");

        // Initialize Strategies
        RideMatchingStrategy matchingStrategy = new NearestDriverStrategy();
        FareStrategy fareStrategy = new DefaultFareStrategy();

        // Initialize RideService
        RideService rideService = new RideService(
                matchingStrategy,
                fareStrategy,
                driverService,
                riderService
        );

        System.out.println("===== START TEST =====");

        // 🔹 1. Request Ride
        Ride ride1 = rideService.requestRide(r1.getId(), 10.0);
        System.out.println("Ride1 Assigned Driver: " + ride1.getDriver().getName());
        System.out.println("Ride1 Fare: " + ride1.getFareReceipt().getAmount());

        // 🔹 2. Complete Ride
        rideService.completeRide(ride1.getId());
        System.out.println("Ride1 Completed");

        // 🔹 3. Request Another Ride
        Ride ride2 = rideService.requestRide(r2.getId(), 5.0);
        System.out.println("Ride2 Assigned Driver: " + ride2.getDriver().getName());

        // 🔹 4. Cancel Ride
        rideService.cancelRide(ride2.getId());
        System.out.println("Ride2 Cancelled");

        // 🔹 5. Switch Fare Strategy (Peak Hour)
        rideService.setFareStrategy(new PeakHourFareStrategy());

        Ride ride3 = rideService.requestRide(r1.getId(), 8.0);
        System.out.println("Ride3 (Peak Pricing) Fare: " + ride3.getFareReceipt().getAmount());

        System.out.println("===== END TEST =====");
    }
}