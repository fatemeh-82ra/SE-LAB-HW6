package com.energy.management.state;
public interface SystemState {
    void handleStateChange();
    String getStatus();
}