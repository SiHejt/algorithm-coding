import java.util.*;

public class Main {
    static int n, m; // n: 정점의 개수, m: 간선의 개수
    static ArrayList<Integer>[] graph; // 인접 리스트로 그래프 표현
    static boolean[] visited; // 정점 방문 여부
    static int vertexCount, edgeCount; // 현재 탐색 중인 연결 요소의 정점 및 간선 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = 1; // 테스트 케이스 번호

        // 0 0을 만날 때까지 반복
        while (true) {
            n = sc.nextInt();
            m = sc.nextInt();

            if (n == 0 && m == 0) {
                break;
            }

            // 그래프 초기화 (1번 정점부터 n번 정점까지)
            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            visited = new boolean[n + 1];

            // 간선 정보 입력
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }

            int treeCount = 0; // 트리의 개수를 저장할 변수
            
            // 모든 정점을 순회하며 연결 요소 탐색
            for (int i = 1; i <= n; i++) {
                // 아직 방문하지 않은 정점에서 새로운 연결 요소 탐색 시작
                if (!visited[i]) {
                    vertexCount = 0;
                    edgeCount = 0;
                    dfs(i);
                    
                    //정점의 수 - 1 = 간선의 수 라는 성질
                    // 즉, edgeCount / 2 == vertexCount - 1
                    if (edgeCount / 2 == vertexCount - 1) {
                        treeCount++;
                    }
                }
            }

            System.out.print("Case " + caseNum + ": ");
            if (treeCount == 0) {
                System.out.println("No trees.");
            } else if (treeCount == 1) {
                System.out.println("There is one tree.");
            } else {
                System.out.println("A forest of " + treeCount + " trees.");
            }
            
            caseNum++;
        }
    }

    static void dfs(int node) {
        visited[node] = true; // 현재 정점 방문 처리
        vertexCount++; // 연결 요소의 정점 수 1 증가
        edgeCount += graph[node].size(); // 현재 정점과 연결된 간선 수 추가

        // 현재 정점과 연결된 모든 정점을 순회
        for (int nextNode : graph[node]) {
            // 아직 방문하지 않은 정점이라면
            if (!visited[nextNode]) {
                dfs(nextNode); // 재귀 호출로 다음 정점 탐색
            }
        }
    }
}