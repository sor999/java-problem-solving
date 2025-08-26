/*
int  [] = {곱점수, 합산 점수, 등번호} 저장
곱점수 > 합산 점수 > 등번호 낮은 순으로 정렬


최대 크기: 999^3 -> 10^9

시간 복잡도: O(3nlogn) = 3 * 100 * log100 = 3*10^2*7

*/

import java.util.*;
import java.io.*;
public class Main {
    //1. 미리 계산
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<int []> lst = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());


            lst.add(new int [] {x*y*z, x + y + z, num});
        }

        Collections.sort(lst, (a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            else if(a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++){
            sb.append(lst.get(i)[2]).append(" ");
        }
        System.out.println(sb.toString());
    }

    // //2. Comparator 활용
    // public static void main(String[] args) throws IOException{

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st;

    //     List<int []> lst = new ArrayList<>();

    //     int n = Integer.parseInt(br.readLine());

    //     for(int i=0; i<n; i++){
    //         st = new StringTokenizer(br.readLine());
    //         int num = Integer.parseInt(st.nextToken());
    //         int x = Integer.parseInt(st.nextToken());
    //         int y = Integer.parseInt(st.nextToken());
    //         int z = Integer.parseInt(st.nextToken());

    //         lst.add(new int []{num, x, y, z});
    //     }

    //     Collections.sort(lst, Comparator.comparingInt((int[] o) -> o[1]*o[2]*o[3])
    //             .thenComparingInt(o -> o[1] + o[2] + o[3])
    //             .thenComparingInt(o -> o[0]));


    //     StringBuilder sb = new StringBuilder();
    //     for(int i=0; i<3; i++){
    //         sb.append(lst.get(i)[0]).append(" ");
    //     }
    //     System.out.println(sb.toString());
    // }

    // //2. 식 직접 쓰기

    // public static void main(String[] args) throws IOException{

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StringTokenizer st;

    //     List<int []> lst = new ArrayList<>();

    //     int n = Integer.parseInt(br.readLine());

    //     for(int i=0; i<n; i++){
    //         st = new StringTokenizer(br.readLine());
    //         int num = Integer.parseInt(st.nextToken());
    //         int x = Integer.parseInt(st.nextToken());
    //         int y = Integer.parseInt(st.nextToken());
    //         int z = Integer.parseInt(st.nextToken());

    //         lst.add(new int []{num, x, y, z});
    //     }

    //     Collections.sort(lst, (a,b) -> {
    //         int mulA = a[1]*a[2]*a[3];
    //         int mulB = b[1]*b[2]*b[3];
    //         int sumA = a[1] + a[2] + a[3];
    //         int sumB = b[1] + b[2] + b[3];
    //         if(mulA != mulB) return mulA - mulB;
    //         else if(sumA != sumB) return sumA - sumB;
    //         return a[0] - b[0];
    //     });


    //     StringBuilder sb = new StringBuilder();
    //     for(int i=0; i<3; i++){
    //         sb.append(lst.get(i)[0]).append(" ");
    //     }
    //     System.out.println(sb.toString());
    // }
}