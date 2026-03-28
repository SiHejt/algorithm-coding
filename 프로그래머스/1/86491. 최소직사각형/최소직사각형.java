import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int maxa = -1;
        int maxb = -1;
        
        for(int[] row : sizes) {
            Arrays.sort(row);
            
            maxa = Math.max(maxa, row[0]);
            maxb = Math.max(maxb, row[1]);
        }
        
        return maxa*maxb;
    }
}