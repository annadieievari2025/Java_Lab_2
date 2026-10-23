package org.example;

import java.math.BigDecimal;

public class RepairOrderService {
    private final RepairOrderRepository repository;
    private final PricingPolicy pricingPolicy;

    public RepairOrderService(RepairOrderRepository repository, PricingPolicy pricingPolicy) {
        this.repository = repository;
        this.pricingPolicy = pricingPolicy;
    }

    public RepairOrder createOrder(Car car) {
        RepairOrder order = new RepairOrder(car);
        repository.save(order);
        return order;
    }

    public void addJobToOrder(int orderId, Job job) {
        RepairOrder order = repository.findById(orderId);
        order.addJob(job);
        repository.save(order);
    }

    public void approveOrder(int orderId) {
        RepairOrder order = repository.findById(orderId);
        order.approve();
        repository.save(order);
    }

    public BigDecimal checkout(int orderId) {
        RepairOrder order = repository.findById(orderId);
        return pricingPolicy.calculateCommercialPrice(order);
    }
}