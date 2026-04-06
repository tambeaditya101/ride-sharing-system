package util;

public class IdGenerator {

    private static long riderId = 1;
    private static long driverId = 1;
    private static long rideId = 1;

    public static long getNextRiderId() {
        return riderId++;
    }

    public static long getNextDriverId() {
        return driverId++;
    }

    public static long getNextRideId() {
        return rideId++;
    }
}
