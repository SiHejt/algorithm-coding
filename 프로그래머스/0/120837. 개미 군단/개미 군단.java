class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        int five = hp/5;
        int three = hp%5 / 3;
        int one = hp%5 % 3;
        
        return five+three+one;
    }
}