import java.util.*;

public class Knapsack {
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    int[][] a = new int[20][50];

    void knap(int n, int[] w, int[] p, int c) {
        int i, j;
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= c; j++) {
                if (i == 0 || j == 0)
                    a[i][j] = 0;
                else if (w[i] > j)
                    a[i][j] = a[i - 1][j];
                else
                    a[i][j] = max(a[i - 1][j], a[i - 1][j - w[i]] + p[i]);
            }
        }

        System.out.println("\nMaximum value that can be put in the knapsack: " + a[n][c]);
        System.out.println("\nDP Table:");
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= c; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nItems included in the knapsack:");
        i = n;
        j = c;
        while (i > 0 && j > 0) {
            if (a[i][j] != a[i - 1][j]) {
                System.out.println("Item " + i + " (Weight: " + w[i] + ", Profit: " + p[i] + ")");
                j = j - w[i];
            }
            i--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Knapsack k = new Knapsack();

        System.out.print("Enter the number of objects: ");
        int n = sc.nextInt();

        int[] w = new int[n + 1];
        int[] p = new int[n + 1];

        System.out.println("Enter the weights of the objects:");
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }

        System.out.println("Enter the profits of the objects:");
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        System.out.print("Enter the maximum capacity of the knapsack: ");
        int c = sc.nextInt();

        k.knap(n, w, p, c);
    }
}
