package com.energy.management.strategy;
public class GreenModeTariff implements CostCalculationStrategy {
    @Override
    public double calculateCost(int energyUnits) { return energyUnits * 300.0; }
}