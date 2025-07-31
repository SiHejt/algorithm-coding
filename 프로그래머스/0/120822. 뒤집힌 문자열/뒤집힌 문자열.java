class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(char ch : my_string.toCharArray()){
            answer = ch + answer;
        }
        return answer;
    }
}