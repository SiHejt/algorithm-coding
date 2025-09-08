import java.util.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            if(visited[i]) {
                continue;
            }
            
            q.offer(i);
            visited[i] = true;
            answer++;
            
            while(!q.isEmpty()){
                int current = q.poll();
                
                for(int j=0; j<n; j++){
                    if(!visited[j] && computers[current][j] == 1){
                        q.offer(j);
                        visited[j] = true;
                    }
                }
            }
            
        }
        
        return answer;
    
    }
}