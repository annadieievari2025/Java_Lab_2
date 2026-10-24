package org.example;

import java.math.BigDecimal;

public class Job {
    private final String description;
    private final BigDecimal cost;

    public Job(String description, BigDecimal cost) {
        if (cost == null || cost.compareTo(BigDecimal.ZERO) < 0) {
            throw new CarServiceException("Вартість не може бути від'ємною");
        }
        this.description = description;
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }
}