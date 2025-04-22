
/*
같은 자리수의 같은 숫자 8 이면 ++, 문자 같지 않은 순간에 break
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String l = st.nextToken();
        String r = st.nextToken();
        int ans = 0;
        int idx = 0;
        while(l.length() == r.length() && idx < l.length()){
            if(l.charAt(idx) == r.charAt(idx)){
                if(l.charAt(idx) == '8' && r.charAt(idx) == '8'){
                    ans++;
                }
            }else{
                break;
            }

            idx++;
        }

        System.out.println(ans);
    }
}

