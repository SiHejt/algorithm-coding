import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int sum;
        int cnt = 0;

        for (int i = 1; i < (1 << N); i++) {
            sum = 0;
            for (int k = 0; k < N; k++) {
                if ((i & (1 << k)) != 0) {
                    sum += arr[k];
                }
            }
            if (sum == S) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}