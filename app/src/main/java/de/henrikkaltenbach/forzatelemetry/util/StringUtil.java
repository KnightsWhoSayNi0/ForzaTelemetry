package de.henrikkaltenbach.forzatelemetry.util;

import java.util.Locale;    // Todo: decide on locale

public class StringUtil {

    private StringUtil() {}

    public String format1p2(float fpNumber) {
        return String.format(Locale.GERMANY, "%f", fpNumber);
    }
}
