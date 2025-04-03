/*
10000 을 어떻게 소인수분해 할까
10000/2 -> 5000
5000/2 -> ..
2~n까지 게속 나눈다.
*/
import java.util.*;

class Solution {
    static Set<Integer> set = new LinkedHashSet<>();
    public int[] solution(int n) {

        while(true){

            int mod = getMod(n);
            set.add(mod);
            if(mod == n) break;
            n /= mod;
        }

        return set.stream().mapToInt(i->i).toArray();
    }

    private static int getMod(int a){
        for(int i=2; i<=a; i++){
            if(a%i == 0){
                return i;
            }
        }
        return -1;
    }
}