package com.company;

import java.util.*;

// This is the PressureSensor which is basically a replica of the Sensor classes with little differences

public class PressureSensor implements WeatherDataSource{

    private double currentPressure;
    private List<WeatherDataListener> listeners = new ArrayList<>();

    PressureSensor() {
        updatePressure();
    }

    public double getCurrentPressure() {
        return currentPressure;
    }

    private void updatePressure(){
        currentPressure = new Random().nextDouble() * 100;
    }

    @Override
    public void addListener(WeatherDataListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(WeatherDataListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void update() {
        System.out.println("PressureSensor: getting new data.");
        updatePressure();
        for(WeatherDataListener listener : listeners) {
            listener.updateData(new WeatherData("Pressure", currentPressure){
                @Override
                public String getUpdateMessage() {
                    return "The new Pressure is " + currentPressure;
                }
            });
        }
    }
}
