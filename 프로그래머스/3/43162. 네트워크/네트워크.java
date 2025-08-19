import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i<n; i++) {
            if(visited[i] == false) {
                bfs(n, computers, visited, i);
            } else {
                continue;
            }
        }
        return answer;
    }
    
    public void bfs(int n, int[][] computers, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int current = q.poll();
            for(int i = 0; i<n; i++) {
                if(computers[current][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    q.add(i);
                } 
            }
        }
        answer++;
        return;
    }
}