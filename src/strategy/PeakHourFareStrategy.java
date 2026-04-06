package strategy;

import model.Ride;

public class PeakHourFareStrategy implements FareStrategy {

    @Override
    public double calculateFare(Ride ride) {
        return ride.getDistance() * 15; // higher rate
    }
}