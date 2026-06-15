import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int num = nums.length / 2;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(Integer species : nums) {
            hm.put(species, hm.getOrDefault(species, 0) + 1);
        } 
        
        if(hm.size() > num) {
            return num;
        } else {
            return hm.size();
        }
    }
}