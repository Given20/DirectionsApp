//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.google.maps.android;

class MathUtil {
    static final double EARTH_RADIUS = 6371009.0D;

    MathUtil() {
    }

    static double clamp(double x, double low, double high) {
        return x < low ? low : (x > high ? high : x);
    }

    static double wrap(double n, double min, double max) {
        return n >= min && n < max ? n : mod(n - min, max - min) + min;
    }

    static double mod(double x, double m) {
        return (x % m + m) % m;
    }

    static double mercator(double lat) {
        return Math.log(Math.tan(lat * 0.5D + 0.7853981633974483D));
    }

    static double inverseMercator(double y) {
        return 2.0D * Math.atan(Math.exp(y)) - 1.5707963267948966D;
    }

    static double hav(double x) {
        double sinHalf = Math.sin(x * 0.5D);
        return sinHalf * sinHalf;
    }

    static double arcHav(double x) {
        return 2.0D * Math.asin(Math.sqrt(x));
    }

    static double sinFromHav(double h) {
        return 2.0D * Math.sqrt(h * (1.0D - h));
    }

    static double havFromSin(double x) {
        double x2 = x * x;
        return x2 / (1.0D + Math.sqrt(1.0D - x2)) * 0.5D;
    }

    static double sinSumFromHav(double x, double y) {
        double a = Math.sqrt(x * (1.0D - x));
        double b = Math.sqrt(y * (1.0D - y));
        return 2.0D * (a + b - 2.0D * (a * y + b * x));
    }

    static double havDistance(double lat1, double lat2, double dLng) {
        return hav(lat1 - lat2) + hav(dLng) * Math.cos(lat1) * Math.cos(lat2);
    }
}
