
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringBuilder sb = new StringBuilder();
        int t = 1;
        while(true){
            String str = br.readLine();

            if(str.charAt(0) == '-') break;
            Stack<Character> stk = new Stack<>();

            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == '}') {
                    if(!stk.isEmpty() && stk.peek() == '{'){
                        stk.pop();
                        continue;
                    }
                }
                stk.push(str.charAt(i));
            }

            List<Character> list = new ArrayList<>(stk);
            int cnt = 0;
            for(int i=0; i<list.size(); i+=2){
                if(list.get(i) != '{') cnt++;
                if(list.get(i+1) != '}') cnt++;
            }
            sb.append(t).append(". ").append(cnt).append("\n");
            t++;
        }

        System.out.println(sb);

    }
}