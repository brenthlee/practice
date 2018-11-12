import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.print("Enter a number to take the fib of: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        /* To test naive recursion */
        //System.out.println("The fib of " + n + " is: " + naiveFib(n));

        /* To test top down with memoization which we never use */
        //System.out.println("The fib of " + n + " is: " + tdFib(n));

        /* To test bottom up */
        System.out.println("The fib of " + n + " is: " + buFib(n));
    }

    // naive recursion (not used in main)
    // T(n)=O(2^n)
    public static int naiveFib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return naiveFib(n-1) + naiveFib(n-2);
    }

    // top down with memoization (not used int main)
    // T(n)=T(n-1)+O(1)
    // therefore, T(n)=O(n)
    public static int tdFib(int n) {
        int[] A = new int[n+1];
        return fib_aux(n, A);
    }

    private static int fib_aux(int n, int[] A) {
        if (A[n] > 0) {
            return A[n];
        }
        if (n == 1 || n == 2) {
            A[n] = 1;
        } else {
            A[n] = fib_aux(n-1, A) + fib_aux(n-2, A);
        }
        return A[n];
    }

    // bottom up dynamic approach
    // T(n)=O(n)
    public static int buFib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] A = new int[n+1];
        A[1] = 1;
        A[2] = 1;
        for (int i = 3; i <= n; i++) {
            A[i] = A[i-1] + A[i-2];
        }
        return A[n];
    }
}
