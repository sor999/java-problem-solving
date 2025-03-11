/*

1. 추천 시작 전 사진 x
2. 추천 -> ++
3.사진 삭제 -> 추천수 0

1000 번이니까 nlonn 가능.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 사진틀 수
        int total = Integer.parseInt(br.readLine()); // 총 추천수

        Map<Integer, int []> map = new HashMap<>(); // 번호: 갯수, 순서

        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i=0; i<total; i++){
            int cur = Integer.parseInt(st.nextToken());

            if(map.containsKey(cur)){
                map.put(cur, new int [] {map.get(cur)[0] + 1, map.get(cur)[1]});
            }else{
                if(list.size() < n){
                    list.add(cur);
                    map.put(cur, new int [] {1, i});
                }else{
                    int num = 0;
                    int min = 1001;
                    int idx = 0;
                    for(int r=0; r<list.size(); r++){
                        int temp = list.get(r);
                        if(map.get(temp)[0] < min){
                            min = map.get(temp)[0];
                            idx = r;
                            num = temp;
                        }
                    }
                    list.remove(idx);
                    map.remove(num);

                    list.add(cur);
                    map.put(cur, new int [] {1, i});
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int v: list){
            sb.append(v).append(" ");
        }


        System.out.println(sb);
    }
}