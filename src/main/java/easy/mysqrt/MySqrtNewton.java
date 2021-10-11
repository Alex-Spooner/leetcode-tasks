package easy.mysqrt;

public class MySqrtNewton implements MySqrt {
    @Override
    public int mySqrt(int x) {
        if (x <= 1) return x;

        double guess = x / 2.0;
        double prev;
        while (true) {
            prev = guess;
            guess = (guess + x / guess) / 2;
            if (Math.round(guess * 100000d) / 100000d == Math.round(prev * 100000d) / 100000d) {
                return (int) guess;
            }
        }
    }
}
