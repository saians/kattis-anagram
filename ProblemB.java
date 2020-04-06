import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemB {

    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {

            System.out.println(countingAnagramsTest(scanner.nextLine()));
            
        }

        scanner.close();
        
    }

    public static BigInteger countingAnagramsTest(final String str) {
        BigInteger denom = BigInteger.ONE;
        Map<String, Integer> alphabetCount = new HashMap<String, Integer>();
        String[] alfabets = str.split("");
        for (int i = 0; i < alfabets.length; i++) {
             String alphabet = alfabets[i];
             Integer countValue = alphabetCount.get(alphabet);
            if (null == countValue) {
                alphabetCount.put(alphabet, 1);
            } else {
                alphabetCount.put(alphabet, countValue + 1);
            }
        }
        for (final Map.Entry<String, Integer> entry : alphabetCount.entrySet()) {
            denom = denom.multiply(calculateFactorialVal(entry.getValue()));
        }

        final int stringLen = str.length();
        final BigInteger numeratorValue = calculateFactorialVal(stringLen);

        return numeratorValue.divide(denom);
    }

    private static BigInteger calculateFactorialVal(final int n) {
        if (0 == n || 1 == n) {
            return BigInteger.ONE;
        }

        BigInteger final_value_cal = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            final_value_cal = final_value_cal.multiply(BigInteger.valueOf(i));
        }
        return final_value_cal;
    }

}