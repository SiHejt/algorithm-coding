import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String cloth[] : clothes) {
            String type = cloth[1];
            hm.put(type, hm.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for(int i : hm.values()) {
            answer *= i+1;
        }
        
        return answer - 1;
    }
}