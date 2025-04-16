/*
2번 해봤을 때 차이가 동일 -> 등차. 마지막 값 +등차
else -> 등비 -> 등비는 next/prev, 마지막값 + 등비

*/
class Solution {
    public int solution(int[] common) {

        int a = common[0];
        int b = common[1];
        int c = common[2];

        if(a-b == b-c){
            int d = c-b;

            return common[common.length-1] + d;
        }else{

            int r = b/a;
            return common[common.length-1]*r;
        }
    }
}