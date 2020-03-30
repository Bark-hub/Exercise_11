package com.company;

import java.util.*;

public interface WeatherDataSource {
    public void addListener(WeatherDataListener listener);
    public void removeListener(WeatherDataListener listener);
    public void update();
}
