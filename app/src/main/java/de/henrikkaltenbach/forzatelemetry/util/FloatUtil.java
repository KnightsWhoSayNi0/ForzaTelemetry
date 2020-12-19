package de.henrikkaltenbach.forzatelemetry.util;

public class FloatUtil {

    private FloatUtil() {}

    public float convertFahrenheitToCelsius(float temperature) {
        return (temperature - 32f) / 1.8f;
    }

    public float convertPsiToBar(float pressure) {
        return pressure * 0.06894757f;
    }
}
