package model;

public class Ride {

    private long id;
    private Rider rider;
    private Driver driver;
    private double distance;
    private RideStatus status;
    private FareReciept fareReceipt;

    public Ride(long id, Rider rider, Driver driver, double distance, RideStatus status) {
        this.id = id;
        this.rider = rider;
        this.driver = driver;
        this.distance = distance;
        this.status = RideStatus.REQUESTED;;

    }

    public Ride(Rider rider, Driver driver, double distance) {
        this.rider = rider;
        this.driver = driver;
        this.distance = distance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public FareReciept getFareReceipt() {
        return fareReceipt;
    }

    public void setFareReciept(FareReciept fareReceipt) {
        this.fareReceipt = fareReceipt;
    }
}
