package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RepairOrder {
    private static int idCounter = 1;
    private final int id;
    private final Car car;
    private final List<Job> jobs = new ArrayList<>();
    private String status = "CREATED";

    public RepairOrder(Car car) {
        this.id = idCounter++;
        this.car = car;
    }

    public int getId() { return id; }
    public String getStatus() { return status; }

    public void addJob(Job job) {
        if (!status.equals("CREATED")) throw new CarServiceException("Неможливо додати роботу");
        jobs.add(job);
    }

    public void approve() {
        if (jobs.isEmpty()) throw new CarServiceException("Немає робіт для погодження");
        this.status = "APPROVED";
    }

    public BigDecimal calculateBaseCost() {
        BigDecimal total = BigDecimal.ZERO;
        for (Job job : jobs) total = total.add(job.getCost());
        return total;
    }
}