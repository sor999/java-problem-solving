class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int idx = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (Character.isDigit(c)) {
                if (c == '1' && i+1 < dartResult.length() && dartResult.charAt(i+1) == '0') {
                    scores[idx] = 10;
                    i++;
                } else {
                    scores[idx] = c - '0';
                }
            }
            else if (c == 'S' || c == 'D' || c == 'T') {
                if (c == 'D') {
                    scores[idx] = (int)Math.pow(scores[idx], 2);
                } else if (c == 'T') {
                    scores[idx] = (int)Math.pow(scores[idx], 3);
                }

                idx++;
            }
            else if (c =='*' || c =='#') {
                if (c == '*') {
                    if (idx > 1) {
                        scores[idx-1]*= 2;
                        scores[idx-2]*= 2;
                    } else {
                        scores[idx-1]*= 2;
                    }
                } else {
                    scores[idx-1]*=-1;
                }
            }
        }
        return scores[0] + scores[1] + scores[2];
    }
}