package com.energy.management.state;
public class ShutdownState implements SystemState {
    @Override
    public void handleStateChange() { System.out.println("Shutting down. All systems are OFF."); }
    @Override
    public String getStatus() { return "System is currently Shutdown."; }
}