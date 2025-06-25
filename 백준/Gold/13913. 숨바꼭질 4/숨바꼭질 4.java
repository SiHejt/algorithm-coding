import java.util.*;

public class Main {
    public static final int MAX = 1000000;

    static void print(int[] from, int n, int m) {
        if (n != m) {
            print(from, n, from[m]);
        }
        System.out.print(m + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] check = new boolean[MAX];
        int[] time = new int[MAX];
        int[] from = new int[MAX];
        check[n] = true;
        time[n] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            if (now - 1 >= 0) {
                if (!check[now - 1]) {
                    q.add(now - 1);
                    check[now - 1] = true;
                    time[now - 1] = time[now] + 1;
                    from[now - 1] = now;
                }
            }
            if (now + 1 < MAX) {
                if (!check[now + 1]) {
                    q.add(now + 1);
                    check[now + 1] = true;
                    time[now + 1] = time[now] + 1;
                    from[now + 1] = now;
                }
            }
            if (now * 2 < MAX) {
                if (!check[now * 2]) {
                    q.add(now * 2);
                    check[now * 2] = true;
                    time[now * 2] = time[now] + 1;
                    from[now * 2] = now;
                }
            }
        }
        System.out.println(time[m]);
        print(from, n, m);
    }
}