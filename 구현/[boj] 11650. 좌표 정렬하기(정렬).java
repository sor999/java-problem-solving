/*
시간복잡도: O(2*nlogn) = O(2 * 10^5*log(10^5)) = 2*10^5*17
 */

import java.util.*;
import java.io.*;
public class Main {
    // 1. list + 배열
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<int []> lst = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            lst.add(new int [] {x, y});
        }

        Collections.sort(lst, (a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });


        StringBuilder sb = new StringBuilder();
        for(int [] now : lst){
            sb.append(now[0]).append(" ").append(now[1]).append("\n");
        }
        System.out.println(sb.toString());
    }

    // 2. 이차원 배열
    // public static void main(String[] args) throws IOException{

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st;


    //     int n = Integer.parseInt(br.readLine());

    //     int [][] arr = new int [n][2];

    //     for(int i=0; i<n; i++){
    //         st = new StringTokenizer(br.readLine());
    //         int x = Integer.parseInt(st.nextToken());
    //         int y = Integer.parseInt(st.nextToken());
    //         arr[i][0] = x;
    //         arr[i][1] = y;
    //     }

    //     Arrays.sort(arr, (a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);


    //     StringBuilder sb = new StringBuilder();
    //     for(int [] now : arr){
    //         sb.append(now[0]).append(" ").append(now[1]).append("\n");
    //     }
    //     System.out.println(sb.toString());
    // }
}