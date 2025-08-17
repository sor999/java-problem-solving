/*
c개에서 l개를 고른다.


사전순 -> 정렬

조합

모음 1개 이상 -> set에 세팅(여부 검색 O(1))
자음 2개 이상 -> 여집합 개념


시간복잡도: O(nCr) -> O(15C7) -> 15*14*13*12*11*10*9*8*7/7! < 1
*/

import java.util.*;
import java.io.*;
public class Main {

    static StringBuilder sb = new StringBuilder();
    static Set<String> vows = Set.of("a", "e", "i", "o", "u");
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken()); // r
        int c = Integer.parseInt(st.nextToken()); // n
        List<String> lst = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<c; i++){
            lst.add(st.nextToken());
        }
        Collections.sort(lst);
        comb(lst, l, 0, 0, new ArrayList<>());


        System.out.println(sb.toString());
    }

    public static void comb(List<String> lst, int r, int at, int depth, List<String> choose){
        // base case
        if(choose.size() == r){
            if(!isPossible(choose, r)) return;

            for(String c : choose){
                sb.append(c);
            }
            sb.append("\n");
            return;
        }


        // recursive case
        for(int i=at; i<lst.size(); i++){
            choose.add(lst.get(i));
            comb(lst, r, i+1,depth+1, choose);
            choose.remove(choose.size() - 1);
        }
    }

    public static boolean isPossible(List<String> choose, int r){
        int vow = 0; // 모음 cnt

        for(String c : choose){
            if(vows.contains(c)){
                vow++;
            }
        }
        int con = r - vow;
        return vow >= 1 && con >= 2;
    }
}