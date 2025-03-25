import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {

        int n = friends.length;
        int [][] g = new int[n][n];
        Map<String, Integer> name = new HashMap<>();

        for(int i=0; i<n; i++){
            name.put(friends[i], i);
        }

        for(String str : gifts){
            String [] s = str.split(" ");
            int a = name.get(s[0]); // 주는이
            int b = name.get(s[1]); // 받는이
            g[a][b]++;
        }

        int [] ans = new int [n];

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                // 서로 준 가록이 다를 경우
                if(g[i][j] != g[j][i]){
                    if(g[i][j] > g[j][i]) ans[i]++;
                    else ans[j]++;
                }else{// 그게 아닐 경우 -> 선물 지수
                    int ir = 0;// i가 받은 것
                    int ip = 0; // i가 준 거
                    int jr = 0; // j가 받은 것
                    int jp = 0; // j가 준 거
                    for(int k=0; k<n;k++){
                        if(k==i)continue;
                        ir += g[k][i];
                        ip += g[i][k];
                    }

                    for(int k=0; k<n;k++){
                        if(k==j)continue;
                        jr += g[k][j];
                        jp += g[j][k];
                    }

                    int resultA = ip - ir;
                    int resultB = jp - jr;


                    if(resultA > resultB) ans[i]++;
                    else if(resultA < resultB) ans[j]++;


                }

            }
        }

        // 선물 가장 많이 받는 수
        int max = 0;
        for(int v : ans){
            max = Math.max(max, v);
        }

        return max;
    }
}
