package com.energy.management.context;
import com.energy.management.state.*;
import com.energy.management.strategy.*;

public class BuildingEnergyContext {
    private SystemState currentState;
    private CostCalculationStrategy costStrategy;

    public BuildingEnergyContext() {
        this.currentState = new ActiveState();
        this.costStrategy = new StandardTariff(); // Default strategy
        }

    public void changeState(String stateName) {
        SystemState newState = null;
        if ("Active".equalsIgnoreCase(stateName)) {
            newState = new ActiveState();
        } else if ("Eco Mode".equalsIgnoreCase(stateName)) {
            newState = new EcoModeState();
        } else if ("Shutdown".equalsIgnoreCase(stateName)) {
            newState = new ShutdownState();
        }

        if (newState != null) {
            this.currentState = newState;
            this.currentState.handleStateChange();
        } else {
            System.out.println("Invalid state specified. No change made.");
        }
    }

    public String getStatus() {
        return this.currentState.getStatus();
    }

    public void setCostStrategy(String policyName) {
        if ("Standard".equalsIgnoreCase(policyName)) {
            this.costStrategy = new StandardTariff();
            System.out.println("Cost policy changed to Standard Tariff.");
        } else if ("Peak Hours".equalsIgnoreCase(policyName)) {
            this.costStrategy = new PeakHoursTariff();
            System.out.println("Cost policy changed to Peak Hours Tariff.");
        } else if ("Green Mode".equalsIgnoreCase(policyName)) {
            this.costStrategy = new GreenModeTariff();
            System.out.println("Cost policy changed to Green Mode Tariff.");
        } else {
            System.out.println("Invalid policy specified. No change made.");
        }
    }

    public double simulateCost(int energyUnits) {
        return this.costStrategy.calculateCost(energyUnits);
    }
    

}