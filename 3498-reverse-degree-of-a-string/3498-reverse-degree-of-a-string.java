class Solution {
    public int reverseDegree(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            int position = i + 1;
            int reverseValue = 26 - (s.charAt(i) - 'a');

            answer += reverseValue * position;
        }

        return answer;
    }
}