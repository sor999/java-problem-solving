/*
9시 부터
운행: n회
운행 간격: t분
한 셔틀 최대수 : m명


어떤 크루가 몇시에 셔틀 대기열에 도착하는지 알아냄.

9 10 11 12 13
2 3 4 5 6
9(n-1)

*/
import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(String str : timetable){
            int time = toMin(str);
            pq.add(time);
        }

        int start = toMin("09:00");
        int end = 0;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum = 0;
            while(!pq.isEmpty()){
                int cur = pq.peek();
                if(cur <= start && sum < m){
                    pq.poll();
                    sum++;
                    end = cur-1;
                }else{
                    break;
                }
            }
            start += t;
        }

        if(sum < m) end = start - t;

        return toHour(end);
    }

    private static int toMin(String str){
        String [] time = str.split(":");
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);

        return h*60 + m;
    }

    private static String toHour(int n){
        return String.format("%02d", n/60) + ":" +String.format("%02d", n%60);
    }
}