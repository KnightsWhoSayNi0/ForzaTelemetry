package de.henrikkaltenbach.forzatelemetry.util;

import androidx.databinding.Bindable;

public class Convert {

    private Convert() {}

    public static float fahrenheitToCelsius(float temperature) {
        return (temperature - 32f) / 1.8f;
    }

    public static float mpsToMph(float velocity) {
        return velocity * 2.23693629f;
    }

    public static float mpsToKph(float velocity) {
        return velocity * 3.6f;
    }

    public static float psiToBar(float pressure) {
        return pressure * 0.06894757f;
    }
}
