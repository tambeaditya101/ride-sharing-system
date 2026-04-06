package model;

import util.IdGenerator;

public class Driver {

    private long id;
    private String name;
    private String currentLocation;
    private boolean available;
    private int totalRides;

    public Driver(long id, String name, String currentLocation, boolean available) {
        this.id = IdGenerator.getNextDriverId();
        this.name = name;
        this.currentLocation = currentLocation;
        this.available = available;
    }

    public Driver(String name, String currentLocation, boolean available) {
        this.name = name;
        this.currentLocation = currentLocation;
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getTotalRides() {
        return totalRides;
    }

    public void incrementRides() {
        this.totalRides++;
    }
}
