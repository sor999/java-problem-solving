/*
2*2 -> 2*1 + 2*1,
m-1(세로로 자르기) * (m)*(n-1)(각 세로조각에 대해 가로로 자르기)


세로 1번
*/
class Solution {
    public int solution(int M, int N) {
        return (M-1) + M*(N-1);
    }
}