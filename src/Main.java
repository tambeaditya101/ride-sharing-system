import model.Driver;
import model.Ride;
import model.Rider;
import service.DriverService;
import service.RideService;
import service.RiderService;
import strategy.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Services
        RiderService riderService = new RiderService();
        DriverService driverService = new DriverService();

        RideService rideService = new RideService(
                new NearestDriverStrategy(),
                new DefaultFareStrategy(),
                driverService,
                riderService
        );

        while (true) {
            System.out.println("\n===== RideWise Menu =====");
            System.out.println("1. Add Rider");
            System.out.println("2. Add Driver");
            System.out.println("3. View Available Drivers");
            System.out.println("4. Request Ride");
            System.out.println("5. Complete Ride");
            System.out.println("6. Cancel Ride");
            System.out.println("7. View All Rides");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {

                switch (choice) {

                    case 1:
                        System.out.print("Enter rider name: ");
                        String rName = scanner.nextLine();

                        System.out.print("Enter rider location: ");
                        String rLocation = scanner.nextLine();

                        Rider rider = riderService.registerRider(rName, rLocation);
                        System.out.println("Rider added with ID: " + rider.getId());
                        break;

                    case 2:
                        System.out.print("Enter driver name: ");
                        String dName = scanner.nextLine();

                        System.out.print("Enter driver location: ");
                        String dLocation = scanner.nextLine();

                        Driver driver = driverService.registerDriver(dName, dLocation);
                        System.out.println("Driver added with ID: " + driver.getId());
                        break;

                    case 3:
                        List<Driver> drivers = driverService.getAvailableDrivers();

                        if (drivers.isEmpty()) {
                            System.out.println("No available drivers");
                        } else {
                            for (Driver d : drivers) {
                                System.out.println("ID: " + d.getId() +
                                        ", Name: " + d.getName() +
                                        ", Location: " + d.getCurrentLocation());
                            }
                        }
                        break;

                    case 4:
                        System.out.print("Enter rider ID: ");
                        long riderId = scanner.nextLong();

                        System.out.print("Enter distance: ");
                        double distance = scanner.nextDouble();

                        Ride ride = rideService.requestRide(riderId, distance);

                        System.out.println("Ride booked!");
                        System.out.println("Driver: " + ride.getDriver().getName());
                        System.out.println("Fare: " + ride.getFareReceipt().getAmount());
                        break;

                    case 5:
                        System.out.print("Enter ride ID: ");
                        long completeRideId = scanner.nextLong();

                        rideService.completeRide(completeRideId);
                        System.out.println("Ride completed");
                        break;

                    case 6:
                        System.out.print("Enter ride ID: ");
                        long cancelRideId = scanner.nextLong();

                        rideService.cancelRide(cancelRideId);
                        System.out.println("Ride cancelled");
                        break;

                    case 7:
                        List<Ride> rides = rideService.getAllRides();

                        if (rides.isEmpty()) {
                            System.out.println("No rides found");
                        } else {
                            for (Ride r : rides) {
                                System.out.println("RideID: " + r.getId() +
                                        ", Rider: " + r.getRider().getName() +
                                        ", Driver: " + r.getDriver().getName() +
                                        ", Status: " + r.getStatus());
                            }
                        }
                        break;

                    case 8:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice");

                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}