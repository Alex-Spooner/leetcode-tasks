package draft.zeroplusx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problemA {

    public static void main(String[] args) {
        Scanner integerSource = new Scanner(System.in);

        while (integerSource.hasNextInt()) {
            int inputInt = integerSource.nextInt();

            if (inputInt == 4) {
                break;
            }

            int reductionCounter = 0;
            List<Integer> primes;
            do {
                reductionCounter++;
                primes = getPrimesForInteger(inputInt);
                inputInt = primes.stream().reduce(0, Integer::sum);
            } while (primes.size() > 1);

            System.out.println(primes.get(0) + " " + reductionCounter);
        }

        integerSource.close();
    }

    private static List<Integer> getPrimesForInteger(int sourceInt) {
        List<Integer> primes = new ArrayList<>();
        int divisor = 2;
        while (sourceInt > 1 && divisor * divisor <= sourceInt) {
            while (sourceInt % divisor == 0) {
                primes.add(divisor);
                sourceInt /= divisor;
            }
            divisor++;
        }
        if (sourceInt > 1) {
            primes.add(sourceInt);
        }
        return primes;
    }
}
