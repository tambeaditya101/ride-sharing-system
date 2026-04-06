package model;

import util.IdGenerator;

public class Rider {

    private long id ;
    private String name;
    private String location;

    public Rider(long id, String name, String location) {
        this.id = IdGenerator.getNextRiderId();
        this.name = name;
        this.location = location;
    }

    public Rider(String name, String location) {
        this.name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
