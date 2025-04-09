
// class Solution {
//     public int solution(String A, String B) {
//         int ans = 0;

//         int n = A.length();
//         for(int i=n; i>=0; i--){
//             if(B.equals(A.substring(i,n) + A.substring(0,i))){
//                 return ans;
//             }
//             ans++;
//         }
//         return -1;
//     }
// }


class Solution {
    public int solution(String A, String B) {
        B = B.repeat(3);

        return B.indexOf(A);
    }
}