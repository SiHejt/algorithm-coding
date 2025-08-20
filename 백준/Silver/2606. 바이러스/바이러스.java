import java.util.*;

public class Main {
    static int n;
    static int[][] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(1);

        System.out.println(count);
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int i = 1; i <= n; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                count++;
                dfs(i);
            }
        }
    }
}
