import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> runners = new HashMap<>();
        
        for(String runner : participant) {
            runners.put(runner, runners.getOrDefault(runner, 0) +1);
        }
        
        for(String runner : completion) {
            runners.put(runner, runners.get(runner) -1);
        }
        
        for(String runner : runners.keySet()) {
            if(runners.get(runner) != 0)
                return runner;
        }
        return "";
    }
}