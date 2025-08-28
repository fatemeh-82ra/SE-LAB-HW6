package com.energy.management.state;
public class ActiveState implements SystemState {
    @Override
    public void handleStateChange() { System.out.println("All systems are now ON."); }
    @Override
    public String getStatus() { return "System is currently Active."; }
}