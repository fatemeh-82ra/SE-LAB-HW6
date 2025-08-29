package com.energy.management.strategy;
public class PeakHoursTariff implements CostCalculationStrategy {
    @Override
    public double calculateCost(int energyUnits) { return energyUnits * 1000.0; }
}