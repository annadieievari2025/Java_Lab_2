package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PricingPolicyTest {

    private final StandardPricingPolicy policy = new StandardPricingPolicy();

    @ParameterizedTest(name = "Базова: {0}, Очікувана комерційна: {1}")
    @CsvSource({
            "300.00, 500.00",
            "5000.00, 5000.00",
            "12000.00, 10800.00"
    })
    void testCalculateCommercialPrice(String baseCostStr, String expectedCostStr) {
        RepairOrder mockOrder = new RepairOrder(new Car("VIN111")) {
            @Override
            public BigDecimal calculateBaseCost() {
                return new BigDecimal(baseCostStr);
            }
        };

        BigDecimal actualCost = policy.calculateCommercialPrice(mockOrder);

        BigDecimal expectedCost = new BigDecimal(expectedCostStr);
        assertEquals(0, expectedCost.compareTo(actualCost)); // 0 означає, що значення рівні
    }
}