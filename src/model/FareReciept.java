package model;

import java.time.LocalDateTime;

public class FareReciept {

    private long id;
    private double amount;
    private LocalDateTime generatedAt;

    public FareReciept(long id, double amount, LocalDateTime generatedAt) {
        this.id = id;
        this.amount = amount;
        this.generatedAt = generatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }
}
