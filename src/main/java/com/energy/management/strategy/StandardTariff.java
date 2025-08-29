package com.energy.management.strategy;
public class StandardTariff implements CostCalculationStrategy {
    @Override
    public double calculateCost(int energyUnits) { return energyUnits * 500.0; }
}