import model.Driver;
import model.Ride;
import model.Rider;
import service.DriverService;
import service.RideService;
import service.RiderService;
import strategy.DefaultFareStrategy;
import strategy.NearestDriverStrategy;

public static void main(String[] args) {

    RiderService riderService = new RiderService();
    DriverService driverService = new DriverService();

    Rider r1 = riderService.registerRider("Aditya", "Mumbai");
    Driver d1 = driverService.registerDriver("Driver1", "Mumbai");

    RideService rideService = new RideService(
            new NearestDriverStrategy(),
            new DefaultFareStrategy(),
            driverService,
            riderService
    );

    Ride ride = rideService.requestRide(r1.getId(), 5.0);

    System.out.println("Ride assigned to: " + ride.getDriver().getName());

    rideService.completeRide(ride.getId());

    System.out.println("Ride completed");
}