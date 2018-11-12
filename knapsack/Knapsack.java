public class Knapsack {
    public static void main(String[] args) {
        int[] p = {10, 40, 30, 50};
        int[] m = {5, 4, 6, 3};
        int W = 10;
        int N = 4;
        int[][] V = new int[N+1][W+1];
        int[][] B = new int[N+1][W+1];
        int ans = knapVal(p, m, W, B, V);
        System.out.println("The answer is: " + ans);
        System.out.print("The items to take are: ");
        print(B, N, W, m);
    }

    public static int knapVal(int[] p, int[] m, int W, int[][] B, int[][] V) {
        int N = p.length;
        for (int w = 0; w <= W; w++) {
            V[0][w] = 0;
        }
        for (int n = 1; n <= N; n++) {
            for (int w = 0; w <= W; w++) {
                if (m[n-1] > w) {
                    V[n][w] = V[n-1][w];
                    B[n][w] = 0;
                } else {
                    if (V[n-1][w] > V[n-1][w-m[n-1]] + p[n-1]) {
                        V[n][w] = V[n-1][w];
                        B[n][w] = 0;
                    } else {
                        V[n][w] = V[n-1][w-m[n-1]] + p[n-1];
                        B[n][w] = 1;
                    }
                }
            }
        }
        System.out.println("V array:");
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                System.out.printf("%2d ", V[i][j]);
            }
            System.out.println("");
        }
        System.out.println("B array:");
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                if (i == 0) {
                    System.out.print(" - ");
                } else if (j == 0) {
                    System.out.print(" - ");
                } else {
                    System.out.printf("%2d ", B[i][j]);
                }
            }
            System.out.println("");
        }
        return V[N][W];
    }

    private static void print(int[][] B, int N, int W, int[] m) {
        int w = W;
        for (int n = N; n > 0; n--) {
            if (B[n][w] == 1) {
                System.out.print(n + " ");
                w -= m[n-1];
            }
        }
        System.out.println("");
    }
}
