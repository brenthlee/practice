import java.util.*;

public class Rod {
    public static void main(String[] args) {
        System.out.println("prices are {1, 5, 8, 9, 10, 13, 17, 20, 24, 25}");
        System.out.print("Enter a length between 1-10: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] P = {0, 1, 5, 8, 9, 10, 13, 17, 20, 24, 25};
        //System.out.println("The max revenue for a rod of length " + n + " is: " + naiveCut(n, P));
        System.out.println("The max revenue for a rod of length " + n + " is: " + buCut(n, P));
    }
    
    // naive recursion (not used in main)
    // T(n)=sum(i =0 to n-1) of (T(i)+theta(1))
    // Therefore, T(n)=theta(2^n)
    // n is the length and P is the list of prices
    public static int naiveCut(int n, int[] P) {
        if (n == 0) {
            return 0;
        }
        int max = -99999;
        for (int i = 1; i <= n; i++) {
            int tmp = P[i] + naiveCut(n-i, P);
            if (max < tmp) {
                max = tmp;
            }
        }
        return max;
    }

    // bottom up
    // T(n)=O(n^2)
    public static int buCut(int n, int[] P) {
        int[] R = new int[n+1];
        R[0] = 0;
        for (int size = 1; size <= n; size++) {
            int max = -99999;
            for (int i = 1; i <= size; i++) {
                int tmp = P[i] + R[size-i];
                if (tmp > max) {
                    max = tmp;
                }
            }
            R[size] = max;
        }
        return R[n];
    }
}
