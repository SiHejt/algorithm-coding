import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] a = new int[n + 1][n + 1];
        int[][] d = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        d[1][1] = a[1][1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    d[i][j] = d[i - 1][j] + a[i][j];
                } else if (j == i) {
                    d[i][j] = d[i - 1][j - 1] + a[i][j];
                } else {
                    d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + a[i][j];
                }
                d[i][j] = Math.max(d[i-1][j], d[i-1][j-1]) + a[i][j];
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, d[n][i]);
        }
        System.out.println(ans);

    }
}