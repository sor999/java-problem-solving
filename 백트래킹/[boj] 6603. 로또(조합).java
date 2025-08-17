/*
집합 s에서 k개를 고른다.

조합 백트래킹

시간복잡도: O(kC6 -> 13C6) = 10*6/6!

*/

import java.util.*;
import java.io.*;
public class Main {


    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while(!(line = br.readLine()).equals("0")){
            String [] str = line.split(" ");
            int r = Integer.parseInt(str[0]);
            List<Integer> s = new ArrayList<>();

            for(int i=1; i<str.length; i++){
                s.add(Integer.parseInt(str[i]));
            }

            comb(s, 6, 0, 0, new ArrayList<>());
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void comb(List<Integer> lst, int r, int at, int depth, List<Integer> choose){
        // base case
        if(choose.size() == r){
            for(int c : choose){
                sb.append(c).append(" ");
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
}