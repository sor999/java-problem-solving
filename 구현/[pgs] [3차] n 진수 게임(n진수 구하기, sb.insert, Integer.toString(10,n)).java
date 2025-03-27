/*
n진수로 변환.
처음 숫자가 n
0, 1, 10, 11, 100, 101, ...
길이를 구하면 되겠다.
2진법 -> 0~1, 2로 나누기

5 -> 101 : 5%2 = 1, 2%2 = 0  1%2 = 1, 0
6 -> 110 : 6%2 = 0, 3%2 = 1, 1%2 = 1, 0
t*p -> 가능


Integer.toString(십진수, base) -> 진법 변환 가능.
*/
class Solution {

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder("0");
        StringBuilder ans = new StringBuilder();

        int num10 = 1;

        //자릿수 생성.
        while(sb.length() < t * m) {
            sb.append(toN(num10, n));
            num10++;
        }

        for(int i = p-1; i < sb.length(); i += m) {
            if(ans.length() >= t) break;
            ans.append(sb.charAt(i));
        }



        return ans.toString();
    }

    private static String toN(int num10, int n){
        // if (num10 == 0) return "0";

        int numN = num10;

        StringBuilder result = new StringBuilder();
        while(numN > 0){
            if(n >= 11 && numN%n >= 10){
                result.insert(0,(char)(numN%n - 10 + 'A')); // char 변환 조심
            }else{
                result.insert(0,numN%n);
            }

            numN /= n;
        }
        return result.toString();
    }


}