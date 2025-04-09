/*
기약분수 -> gcd
분모 -> 2 or. 5 로 % 해서 안되면 2
*/
class Solution {
    public int solution(int a, int b) {
        int g = gcd(a,b);
        int down = b/g;

        while(down > 1){
            if(down%2 == 0) down/=2;
            else if(down%5 == 0) down/=5;
            else return 2;
        }

        return 1;
    }

    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}