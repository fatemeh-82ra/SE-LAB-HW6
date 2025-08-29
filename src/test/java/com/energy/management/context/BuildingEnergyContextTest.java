package com.energy.management.context;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BuildingEnergyContextTest {

    private BuildingEnergyContext context;

    @BeforeEach
    void setUp() {
        context = new BuildingEnergyContext();
    }

    @Test
    void testInitialStateShouldBeActive() {
        assertEquals("System is currently Active.", context.getStatus());
    }

    @Test
    void testChangeStateFromActiveToEco() {
        context.changeState("Eco Mode");
        assertEquals("System is now in Eco Mode.", context.getStatus());
    }

    @Test
    void testChangeStateFromEcoToShutdown() {
        context.changeState("Eco Mode");
        context.changeState("Shutdown");
        assertEquals("System is currently Shutdown.", context.getStatus());
    }

    @Test
    void testChangeStateFromShutdownToActive() {
        context.changeState("Shutdown");
        context.changeState("Active");
        assertEquals("System is currently Active.", context.getStatus());
    }

    @Test
    void testChangeStateToInvalidStateShouldNotChangeState() {
        assertEquals("System is currently Active.", context.getStatus());
        context.changeState("Sleep Mode");
        assertEquals("System is currently Active.", context.getStatus());
    }

    @Test
    void testInitialCostPolicyIsStandard() {
        double cost = context.simulateCost(10); // 10 units
        assertEquals(5000.0, cost, "Initial cost should be calculated with Standard Tariff");
    }

    @Test
    void testPolicyCanBeChangedToPeakHours() {
        context.setCostStrategy("Peak Hours");
        double cost = context.simulateCost(10); // 10 units
        assertEquals(10000.0, cost, "Cost should be calculated with Peak Hours Tariff");
    }

    @Test
    void testPolicyCanBeChangedToGreenMode() {
        context.setCostStrategy("Green Mode");
        double cost = context.simulateCost(20); // 20 units
        assertEquals(6000.0, cost, "Cost should be calculated with Green Mode Tariff");
    }

    @Test
    void testSimulateCostWithZeroUnitsShouldReturnZero() {
        context.setCostStrategy("Peak Hours");
        double cost = context.simulateCost(0);
        assertEquals(0.0, cost, "Cost for zero units should be zero");
    }
}