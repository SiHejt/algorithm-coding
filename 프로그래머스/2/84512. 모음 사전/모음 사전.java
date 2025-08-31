class Solution {
    private static final char[] VOWELS = {'A','E','I','O','U'};
    private int count;
    private int answer;
    
    public int solution(String word) {
        count = 0;
        answer = 0;
        dfs("", word);
        return answer;
    }
    
    private void dfs(String cur, String target) {
        if (cur.length() == 5) return;
        for (char c : VOWELS) {
            String next = cur + c;
            count++;
            if (next.equals(target)) {
                answer = count;
                return;
            }
            dfs(next, target);
            if (answer != 0) return;
        }
    }
}