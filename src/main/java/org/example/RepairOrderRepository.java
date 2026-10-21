package org.example;

public interface RepairOrderRepository {
    void save(RepairOrder order);
    RepairOrder findById(int id);
}