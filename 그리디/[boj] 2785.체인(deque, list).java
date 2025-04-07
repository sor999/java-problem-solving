
/*
n
3 4 5 7 9
가장 작은 개수를 가진 체인을 가장 큰 체인을 연결하는 데 사용하기.
2 4 5 7+9+1 = 2 4 5 17
1 4 5 17 -
0 4 5 17 -> 0 4 22 = 4 22
26
 */
// list
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Long> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            list.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(list);

        int ans = 0;
        while(list.size() > 1){
            list.set(0, list.get(0)-1);
            long prev = list.get(list.size()-2);
            long last = list.get(list.size()-1);

            list.remove(list.size()-1);
            list.remove(list.size()-1);
            list.add(last + prev + 1);
            ans++;
            if(list.get(0) == 0) list.remove(0);
        }
        System.out.print(ans);
    }
}
//deque

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        List<Long> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(list);

        Deque<Long> dq = new ArrayDeque<>(list);

        int ans = 0;
        while(dq.size() > 1){
            long first = dq.pollFirst();

            first--;

            if(first != 0){
                dq.addFirst(first);
            }
            ans++;

            if(dq.size() >= 2) {
                long prev = dq.pollLast();
                long last = dq.pollLast();

                dq.addLast(last + prev + 1);

            }

        }
        System.out.print(ans);
    }
}


