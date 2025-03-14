/*

지도1, 2 ||

1. 이진수로 변환하기 - Integer.toBinaryString(숫자);
2. 자리수마다 or 연산하기 charAt

*/
import java.util.*;
class Solution {
//     public List<String> solution(int n, int[] arr1, int[] arr2) {
//         List<String> ans = new ArrayList<>();

//         for(int i=0; i<n; i++){
//             String b1 = Integer.toBinaryString(arr1[i]);
//             String b2 = Integer.toBinaryString(arr2[i]);
//             String str1 = "0".repeat(n-b1.length()) + b1;
//             String str2 = "0".repeat(n-b2.length()) + b2;
//             char [] chars = new char [n];
//             for(int j=0; j<n; j++){
//                 if(str1.charAt(j) == '0' &&  str2.charAt(j) == '0') chars[j] = ' ';
//                 else chars[j] = '#';
//             }

//             ans.add(new String(chars));
//         }

//         return ans;
//     }

        public List<String> solution(int n, int[] arr1, int[] arr2) {
        List<String> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            String b = Integer.toBinaryString(arr1[i] | arr2[i]);
            String str = String.format("%" + n + "s", b);
            str = str.replaceAll("1", "#");
            str = str.replaceAll("0", " ");
            ans.add(str);
        }

        return ans;
    }
}