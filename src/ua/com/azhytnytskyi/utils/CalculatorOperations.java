package ua.com.azhytnytskyi.utils;

public class CalculatorOperations {

    public static double multiple(double a, double b) {
        if (a == 0 || b == 0) return 0;
        return a * b;
    }

    public static double divide(double a, double b) {
        if (a == 0 || b == 0) return 0;
        return a / b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public static double sqrt(double a) {
        if (a == 0) return 0;
        return Math.sqrt(a);
    }

    public static double pow(double a, double b) {
        if (a == 0 || b == 0) return 0;
        return Math.pow(a, b);
    }

    public static double percent(double a, double b) {
        if (a == 0) return 0;
        return ((a / 10) * (b / 10));
    }

}
