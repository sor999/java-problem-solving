/*
밴할 id는 set에 넣을것.

*/
import java.util.stream.*;
import java.util.*;
class Solution {
    static Set<Set<String>> ans = new HashSet<>();
    static String[] user_id;
    static String[] banned_id;

    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;

        dfs(new HashSet<>(), 0);

        return ans.size();
    }


    private static void dfs(Set<String> banSet, int depth) {
        if (depth == banned_id.length) {
            ans.add(new HashSet<>(banSet));
            return;
        }

        String word = banned_id[depth];

        for (String user : user_id) {
            if (banSet.contains(user) || !match(user, word)) continue; // 유저가 이미 밴셋에 있거나 매치가 안되면 넘어감
            banSet.add(user); // 밴 셋에 넣어줌
            dfs(banSet, depth + 1); // 다음 벤 확인
            banSet.remove(user);
        }
    }


    private static boolean match(String user, String word) {
        if (user.length() != word.length()) {
            return false;
        }

        for (int i = 0; i < user.length(); i++) {
            if (word.charAt(i) != '*' && word.charAt(i) != user.charAt(i)) {
                return false;
            }

        }
        return true;
    }
}