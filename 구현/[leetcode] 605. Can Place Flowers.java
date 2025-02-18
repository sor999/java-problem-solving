/*
인접한 곳에 꽃이 있다면 심지 못함. 최대한 인접하지 않도록 하자
1. 완탐 -> O(n^2) -> 1초 넘음
2. 꽃의 위치를 실시간으로 저장 확인 -> O(n)
*/
import java.util.*;
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int cnt = 0;

        if(n == 0) return true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) continue;
        
            boolean lEmpty = (i == 0) || (flowerbed[i - 1] == 0);

            boolean rEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                

            if (lEmpty && rEmpty) {
                flowerbed[i] = 1;
                cnt++;
                if(cnt >= n) return true;
            }
        }
        
        return cnt >= n; // n == 0일 경우 처리를 해줘야 해서 false로 바로 반환하면 안된다.
    }
}
