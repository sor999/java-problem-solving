
import java.util.*;

class Solution {
    static List<String> ans = new ArrayList<>();
    static String[][] map = new String[51][51]; // 각 셀의 값 저장
    static int[] parent = new int [50*50];        // 유니온 파인드용 부모 배열
    public List<String> solution(String[] commands) {
        // 유니온 파인드 초기화
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (String str : commands) {
            String[] command = str.split(" ");
            switch (command[0]) {
                case "UPDATE":
                    if (command.length == 4) {
                        update(Integer.parseInt(command[1]), Integer.parseInt(command[2]), command[3]);
                    } else {
                        update(command[1], command[2]);
                    }
                    break;
                case "MERGE":
                    merge(Integer.parseInt(command[1]), Integer.parseInt(command[2]), Integer.parseInt(command[3]), Integer.parseInt(command[4]));
                    break;
                case "UNMERGE":
                    unmerge(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                case "PRINT":
                    print(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
            }
        }

        return ans;
    }

    // 특정 셀의 값을 업데이트
    static void update(int r, int c, String value) {
        int pos = (r - 1) * 50 + (c - 1);
        int root = find(pos);

        for(int i=0; i<parent.length; i++){
            if(find(i) == root){
                int r1 = i / 50 + 1;
                int c1 = i % 50 + 1;
                map[r1][c1] = value;
            }
        }
    }

    // value1을 가진 모든 셀을 value2로 업데이트
    static void update(String value1, String value2) {
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                if (map[i][j] != null && map[i][j].equals(value1)) {
                    map[i][j] = value2;
                }
            }
        }
    }

    // 두 셀을 병합
    static void merge(int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) return; // 같은 셀인 경우 무시

        int pos1 = (r1 - 1) * 50 + (c1 - 1);
        int pos2 = (r2 - 1) * 50 + (c2 - 1);
        int root1 = find(pos1);
        int root2 = find(pos2);

        if (root1 == root2) return; // 이미 병합된 셀인 경우

        // 두 셀의 값을 확인
        String value1 = map[r1][c1];
        String value2 = map[r2][c2];

        String finalValue = null;

        // 병합 값 결정
        if (value1 != null) {
            finalValue = value1;
            union(root1, root2);
        } else if (value2 != null) {
            finalValue = value2;
            union(root2, root1);
        } else {
            // 둘 다 값이 없는 경우
            union(root1, root2);
        }

        // 병합된 모든 셀 업데이트
        int root = find(pos1); // 새로운 루트
        for (int i = 0; i < 2500; i++) {
            if (find(i) == root) {
                int r = i / 50 + 1;
                int c = i % 50 + 1;
                map[r][c] = finalValue;
            }
        }
    }

    // 병합된 셀들을 분리
    static void unmerge(int r, int c) {
        int pos = (r - 1) * 50 + (c - 1);
        int root = find(pos);
        String value = map[r][c]; // 현재 셀의 값을 저장

        // 병합된 셀 해제
        for (int i = 0; i < parent.length; i++) {
            if (find(i) == root) {
                int row = i / 50 + 1;
                int col = i % 50 + 1;
                map[row][col] = null; // 병합 해제 후 초기화
                parent[i] = i;        // 셀을 독립시킴
            }
        }

        map[r][c] = value; // 해제된 셀의 값 유지
    }

    // 특정 셀의 값을 출력
    static void print(int r, int c) {
        if (map[r][c] == null) {
            ans.add("EMPTY");
        } else {
            ans.add(map[r][c]);
        }
    }

    // 유니온 파인드에서 부모 노드 찾기
    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    // 두 노드를 병합
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a; // a를 루트로 병합
        }
    }
}

