package strategy;

import model.Ride;

public class DefaultFareStrategy implements FareStrategy {

    @Override
    public double calculateFare(Ride ride) {
        return ride.getDistance() * 10; // simple pricing
    }
}