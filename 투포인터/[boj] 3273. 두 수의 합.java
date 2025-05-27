// O(N)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] arr = new int [n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());
        int end = n-1;
        int start = 0;

        int cnt = 0;

        while(start < end){
            int sum = arr[start] + arr[end];
            if(sum == x){
                cnt++;
                start++;
                end--;
            }else if(sum < x){
                start++;
            }else{
                end--;
            }
        }

        System.out.println(cnt);
    }
}