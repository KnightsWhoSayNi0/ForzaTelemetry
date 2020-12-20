package de.henrikkaltenbach.forzatelemetry.util;

import java.util.Locale;

public class Format {

    private static final Locale locale = Locale.US;

    private Format() {}

    public static String integer(int integer) {
        return String.format(locale, "%d", integer);
    }

    public static String fpNumber(float fpNumber) {
        return String.format(locale, "%f", fpNumber);
    }

    public static String float1p2(float fpNumber) {
        return String.format(locale, "%3.2f", fpNumber);
    }

    public static String float3p0(float fpNumber) {
        return String.format(locale, "%3.0f", fpNumber);
    }

    public static String float3p1(float fpNumber) {
        return String.format(locale, "%4.1f", fpNumber);
    }

    public static String float4p1(float fpNumber) {
        return String.format(locale, "%5.1f", fpNumber);
    }

    public static String float3p2(float fpNumber) {
        return String.format(locale, "%5.2f", fpNumber);
    }

    public static String float4p2(float fpNumber) {
        return String.format(locale, "%6.2f", fpNumber);
    }

    public static String float6p2(float fpNumber) {
        return String.format(locale, "%8.2f", fpNumber);
    }
}
