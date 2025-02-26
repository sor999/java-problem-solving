/*
결국 n*2번 나옴 -> 완탐 가능
비교하는 게 편하려면 List로 담자
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());


        List<Integer> a = new ArrayList<>();
        Queue<Integer> b = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            b.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<n; i++){
            if(b.equals(a)){
                System.out.println("good puzzle");
                return;
            }
            b.offer(b.poll());
        }
        List<Integer> temp = new ArrayList<>(b);
        Collections.reverse(temp);
        b = new LinkedList<>(temp);


        for(int i=0; i<n; i++){
            if(b.equals(a)){
                System.out.println("good puzzle");
                return;
            }
            b.offer(b.poll());
        }
        System.out.println("bad puzzle");
    }
}