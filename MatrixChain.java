import java.util.*;

public class MatrixChain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();
        int[] dim = new int[n + 1];
        System.out.println("Enter dimensions:");
        for (int i = 0; i <= n; i++) {
            dim[i] = sc.nextInt();
        }

        int[][] m = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + dim[i] * dim[k + 1] * dim[j + 1];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        System.out.println("Minimum number of multiplications: " + m[0][n - 1]);
    }
}