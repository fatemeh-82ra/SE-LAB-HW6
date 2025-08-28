package com.energy.management.state;
public class EcoModeState implements SystemState {
    @Override
    public void handleStateChange() { System.out.println("Switching to Eco Mode: Only essential systems are ON."); }
    @Override
    public String getStatus() { return "System is now in Eco Mode."; }
}