
/*
3!^60 -> 완탐 불가능
최솟값 -> bfs
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] num = {9, 3, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] comb = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};

        int[] arr = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{arr[0], arr[1], arr[2], 0});
        boolean[][][] visited = new boolean[61][61][61];
        visited[arr[0]][arr[1]][arr[2]] = true;

        while (!q.isEmpty()) {
            int[] curs = q.poll();

            int cx = curs[0];
            int cy = curs[1];
            int cz = curs[2];
            int cnt = curs[3];

            if (cx <= 0 && cy <= 0 && cz <= 0) {
                System.out.println(cnt);
                return;
            }

            for (int[] order : comb) {
                int nx = Math.max((cx - num[order[0]]), 0);
                int ny = Math.max((cy - num[order[1]]), 0);
                int nz = Math.max((cz - num[order[2]]), 0);

                if (visited[nx][ny][nz]) continue;
                visited[nx][ny][nz] = true;

                q.offer(new int[]{nx, ny, nz, cnt + 1});
            }
        }
    }
}