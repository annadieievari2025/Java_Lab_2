package org.example;

import java.math.BigDecimal;

public class CarServiceDemo {
    public static void main(String[] args) {
        RepairOrderRepository repo = new InMemoryRepairOrderRepository();
        PricingPolicy policy = new StandardPricingPolicy();
        RepairOrderService service = new RepairOrderService(repo, policy);

        System.out.println("=== Автосервіс v2 (SOLID) ===\n");
        Car car = new Car("VIN123");

        RepairOrder order = service.createOrder(car);
        System.out.println("Створено замовлення №" + order.getId());

        service.addJobToOrder(order.getId(), new Job("Заміна двигуна", new BigDecimal("12000.00")));
        service.approveOrder(order.getId());

        BigDecimal finalPrice = service.checkout(order.getId());
        System.out.println("Комерційна вартість: " + finalPrice + " грн");

        try {
            service.approveOrder(999);
        } catch (CarServiceException e) {
            System.out.println("\n[Очікувана помилка] " + e.getMessage());
        }
    }
}