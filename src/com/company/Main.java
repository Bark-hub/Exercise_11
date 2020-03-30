package com.company;

import java.util.*;

// Mubarik Abdi 3/30/2020
// only three sections were modified in the main
public class Main {

    public static void main(String[] args) {
        System.out.println("Main: creating objects");
        WeatherStation localWeatherStation = new WeatherStation();

        TemperatureSensor temperatureSensor = new TemperatureSensor();
        HumiditySensor humiditySensor = new HumiditySensor();
        PressureSensor pressureSensor = new PressureSensor();   // Here is a creation of an instance of Pressure

        temperatureSensor.addListener(localWeatherStation);
        humiditySensor.addListener(localWeatherStation);
        pressureSensor.addListener(localWeatherStation);        // The station being added as a listener

        System.out.println("Main: simulating updates from sensors");
        temperatureSensor.update();
        humiditySensor.update();
        temperatureSensor.update();
        pressureSensor.update();                                // The update method is called for pressure

        System.out.println("Main: displaying report and logs");
        localWeatherStation.displayCurrentWeather();
        localWeatherStation.displayLog();

    }
}
