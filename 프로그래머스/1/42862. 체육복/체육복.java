import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
         for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        for (int l : lost) {
            if (l == -1) {
                answer++;
                continue;
            }
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] != -1 && (reserve[j] == l - 1 || reserve[j] == l + 1)) {
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        return answer + (n - lost.length);
    }
}