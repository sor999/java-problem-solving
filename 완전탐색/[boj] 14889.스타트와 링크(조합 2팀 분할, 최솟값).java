/*
n -> 스타트 반 링크 반
0. nCn/2 구하기.
1. 스타트/ 링크 각각 능력치 구하기
2. 스타트 - 링크 능력치 min

ex. 1 2 3 4
1 2 /3 4 ->1 2 고르면 나머지 3,4는 어떻게 가져올까? 0 과 n-1이 짝
1 3 /2 4
1 4 /2 3
2 3
2 4
3 4

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] w;
    static List<List<Integer>> comb = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        w = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j <= n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getComb(new ArrayList<>(), 1);

        int minDiff = Integer.MAX_VALUE;

        for(int i=0; i<comb.size()/2; i++){
            List<Integer> start = comb.get(i);
            List<Integer> link = comb.get(comb.size()-i-1);

            int startW = getW(start);
            int linkW = getW(link);

            minDiff = Math.min(minDiff, Math.abs(startW - linkW));

        }
        System.out.println(minDiff);
    }

    private static void getComb(List<Integer> num, int at){
        if(n/2 == num.size()){
            comb.add(new ArrayList<>(num));
            return;
        }

        for(int i=at; i<=n; i++){
            num.add(i);
            getComb(num, i+1);
            num.remove(num.size()-1);
        }
    }

    private static int getW(List<Integer> list){
        int result = 0;
        for(int a=0; a<list.size()-1; a++){
            for(int b=a+1; b<list.size(); b++){
                int i = list.get(a);
                int j = list.get(b);
                result += w[i][j] + w[j][i];
            }
        }

        return result;
    }
}