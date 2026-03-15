package math;

public class ArcTg {
    private static final double EPS = 1e-10;

    public static double calculate(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return x;
        }

        if (x > 1) {
            return Math.PI / 2 - calculate(1 / x);
        }
        if (x < -1) {
            return -Math.PI / 2 - calculate(1 / x);
        }

        double sum = 0;
        double term = x;
        int n = 0;

        while (Math.abs(term) > EPS) {
            term = (Math.pow(-1, n) * Math.pow(x, 2 * n + 1)) / (2 * n + 1);
            sum += term;
            n++;
            if (n > 10000) {
                break;
            }
        }
        return sum;
    }
}