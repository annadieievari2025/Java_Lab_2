package org.example;

import java.math.BigDecimal;

public interface PricingPolicy {
    BigDecimal calculateCommercialPrice(RepairOrder order);
}