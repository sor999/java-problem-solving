/*

답을 정해놓고 해당 답이 예상 답이 될 수 있는지 확인. 답이 될 수 있다면 cnt++
예상 답은 9P3으로 구한다.
완탐
시간복잡도: O(9P3)*n
*/

import java.util.*;
import java.io.*;
public class Main {
    static int cnt = 0;
    static List<Integer> nums = new ArrayList<>();
    static List<String []> questions =  new ArrayList<>();
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;


        for(int i=0; i<n; i++){
            String [] question = br.readLine().split(" ");
            questions.add(question);
        }


        dfs(0, new boolean [10]);

        System.out.println(cnt);
    }

    public static void dfs(int depth, boolean [] visited){
        if(depth == 3){
            if(!isPossible()) return;
            cnt++;
            return;
        }

        for(int i=1; i<=9; i++){
            if(visited[i]) continue;
            visited[i] = true;
            nums.add(i);
            dfs(depth+1, visited);
            visited[i] = false;
            nums.remove(nums.size()-1);
        }
    }

    public static boolean isPossible(){

        for(String [] question : questions){
            String num = question[0];
            int st = Integer.parseInt(question[1]);
            int bl = Integer.parseInt(question[2]);

            int curSt = 0;
            int curBl = 0;

            for(int i=0; i<3; i++){
                if(num.charAt(i) - '0' == nums.get(i)){
                    curSt++;
                }else if(nums.contains(num.charAt(i) - '0')){
                    curBl++;
                }
            }

            if(!(st == curSt && bl == curBl)) return false;

        }
        return true;
    }
}