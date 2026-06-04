import java.util.*;

class Solution {
    static class Node {
        String word;
        int step;
        
        Node(String word, int step){
            this.word = word;
            this.step = step;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Node> q = new LinkedList<>();
        int answer = 0;
        
        q.offer(new Node(begin, 0));
        
        
        for(int i=0; i<words.length; i++) {
            while(!q.isEmpty()){
                Node current = q.poll();
                
                if(current.word.equals(target)) {
                    answer = current.step;
                    
                    break;
                }
                
                for(int j=0; j<words.length; j++){
                    if(!visited[j] && canChange(current.word, words[j])) {
                        q.offer(new Node(words[j], current.step+1));
                        visited[j] = true;
                    }
                }
            }
            return answer;
        }
        
        return 0;
    }
    
    public boolean canChange(String s1, String s2) {
        int cnt = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
            if(cnt > 1) return false;
        }
        return true;
    }
}