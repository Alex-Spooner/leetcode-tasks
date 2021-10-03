package easy.mysqrt;

public class MySqrtImpl implements MySqrt {
    @Override
    public int mySqrt(int x) {
        int i = 1;
        while (i * i <= x && x / i >= i) {
            i++;
        }
        return i - 1;
    }
}
