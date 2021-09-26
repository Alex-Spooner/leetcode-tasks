package easy.reverseinteger;

public class ReverseIntegerSimple implements IntegerReverser {
    @Override
    public int reverse(int x) {
        int result = 0;
        int base = 10;
        while (x != 0) {
            int remainder = x % base;
            if (result > 0) {
                if ((Integer.MAX_VALUE / result < base)
                        || ((Integer.MAX_VALUE - result * base) < remainder)) {
                    return 0;
                }
            } else if (result < 0 && result != -1) {
                if ((Integer.MIN_VALUE / result < base)
                        || ((Integer.MIN_VALUE - result * base) > remainder)) {
                    return 0;
                }
            }
            result = result * base + remainder;
            x = (x - remainder) / base;
        }
        return result;
    }
}
