public class MatrixMult {
    public static void main(String[] args) {
        /*
        this is the example from the back page
        the answer is 78 from the upper right corner that we filled out in class
        feel free to comment this out or put it back in as long as you comment out the second list P
        */
        int[] P = {2,3,5,2,4,3};

        /*
        this is the example from the front page
        it shows all 4 different combinations and the lowest number is 7000
        feel free to comment this out or put it back in as long as you comment out the first list P
        */
        //int[] P = {50, 20, 1, 10, 100};

        int[][] S = new int[P.length][P.length];
        System.out.println("Optimal cost is: " + chainmult(P, S));
        print(S,1,P.length-1);
        System.out.println("");
    }
    
    //bottom up

    //P is the list of matrix sizes
    public static int chainmult(int[] P, int[][] S) {
        int n = P.length;
        //int[][] S = new int[n][n];
        int[][] M = new int[n][n];
        for (int l=2; l <= (n-1); l++) {
            for (int i = 1; i <= (n-l); i++) {
                int j = i+l-1;
                M[i][j] = 99999;
                for (int k = i; k <= (j-1); k++) {
                    int x = M[i][k] + M[k+1][j] + P[i-1]*P[k]*P[j];
                    if (x < M[i][j]) {
                        M[i][j] = x;
                        S[i][j] = k;
                    }
                }
            }
        }
        return M[1][n-1];
    }

    private static void print(int[][] S, int i, int j) {
        if (i == j) {
            System.out.print("A"+i);
        } else {
            System.out.print("(");
            print(S,i,S[i][j]);
            print(S,S[i][j]+1,j);
            System.out.print(")");
        }
    }
}
