import java.util.*;
class Solution {
    public int solution(int n) {
        int [] arr = new int [n+1];
        for(int i=1; i<=n; i++){
            for(int j=i; i*j<=n; j++){
                arr[i*j]++;
            }
        }
        int ans = 0;
        for(int i=2; i<=n; i++){
            if(arr[i] >= 2){ // 합성수란 약수의 개수가 3 이상.하지만 자기자신을 빼고 2 이상이면 됨.
                ans++;
            }
        }
        return ans;
    }
}