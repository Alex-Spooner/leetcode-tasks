package medium.pow;

public class MyPowImpl implements MyPow {
    @Override
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        boolean needToSwitchSign = false;
        if (n < 0) {
            n = -n;
            if (n < 0) {
                n = Integer.MAX_VALUE;
                needToSwitchSign = true;
            }
            x = 1 / x;
        }

        double resultBase = 1D;
        double expMultiplier = x;
        while (n > 0) {
            if (n % 2 != 0) {
                resultBase *= expMultiplier;
            }
            expMultiplier *= expMultiplier;
            n = n / 2;
        }

        return needToSwitchSign && resultBase < 0 ? resultBase * (-1) : resultBase;
    }
}
