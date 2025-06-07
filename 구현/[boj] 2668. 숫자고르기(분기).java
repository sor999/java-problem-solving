
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char [][] map = new char [3][3];
        while(true){
            String s = br.readLine();
            if(s.equals("end")) break;

            int oCnt = 0;
            int xCnt = 0;
            for(int i=0; i<9; i++){
                map[i/3][i%3] = s.charAt(i);
                if(s.charAt(i) == 'O') oCnt++;
                if(s.charAt(i) == 'X') xCnt++;
            }

            boolean xWin = isWin(map, 'X');
            boolean oWin = isWin(map, 'O');

            if(xCnt == 5 && oCnt == 4 && !xWin && !oWin) sb.append("valid");
            else if(oCnt + 1 < xCnt || oCnt > xCnt) sb.append("invalid");
            else if(xWin && oWin) sb.append("invalid");
            else if(oWin && xCnt == oCnt) sb.append("valid");
            else if(xWin && xCnt == oCnt+1) sb.append("valid");
            else sb.append("invalid");

            sb.append("\n");
        }


        System.out.println(sb);
    }

    public static boolean isWin(char [][] map, char c){
        // 가로
        for(int i=0; i<3; i++){
            if(c == map[i][0] && c == map[i][1] && c == map[i][2]) return true;
        }

        // 세로
        for(int j=0; j<3; j++){
            if(c == map[0][j] && c == map[1][j] && c == map[2][j]) return true;
        }

        // 대각선

        if(c == map[0][0] && c == map[1][1] && c == map[2][2]) return true;
        if(c == map[0][2] && c == map[1][1] && c == map[2][0]) return true;

        return false;
    }
}
