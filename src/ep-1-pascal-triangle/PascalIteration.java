/**
 * Pascal's triangle is computed using the combination formula
 * n C r = n! / (r! * (n-r)!)
 */
import java.util.Scanner;

public class PascalIteration {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Number of lines in pascal triangle: ");
        int lines = reader.nextInt();

        for (int i = 0; i < lines; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print(computenCr(i, j) + " ");
            }

            System.out.println();
        }
    }

    private static long computenCr(int n, int r) {
        // nCr = nC(n-r)
        // we optimize here so as to get a small r, and hence small factorial value
        int optimizedR = r > n/2 ? n - r : r;

        return getFactorial(n) / (getFactorial(optimizedR) * getFactorial(n-optimizedR));
    }

    private static long getFactorial(int n) {
        long factorial = 1;
        if (n <= 1) {
            return factorial;
        }

        for (int i = 2; i <= n; ++i) {
            factorial *= i;
        }

        return factorial;
    }
}
