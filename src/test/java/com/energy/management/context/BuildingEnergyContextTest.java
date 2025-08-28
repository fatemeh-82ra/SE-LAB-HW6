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
}