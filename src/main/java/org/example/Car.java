package org.example;

public class Car {
    private final String vin;

    public Car(String vin) {
        if (vin == null || vin.isBlank()) {
            throw new CarServiceException("VIN не може бути порожнім");
        }
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }
}