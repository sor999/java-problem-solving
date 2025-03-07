/*
전화 번호를 눌렀을 때 대응되는 문자열 조합을 모두 출력
조합 문제. -> 백트래킹

//방법1. sb + char 사용한 dfs
2-9의 알파벳 배열을 준비해놓자.
그러고서 digits의 각 자리에서 하나씩 뽑는다 -> 외부 for
내부 for에서 하나 선택해서 sb에 넣고
dfs
나올때 sb에서 뺴기
그러다 sb길이 == digits 길이면 정답에 넣고 return


중복되는 숫자를 입력할 수 있나? -> 없다고 보자.

// 방법2. 배열로 하기


*/
class Solution {
    // 방법1. sb + char 사용한 dfs
    public List<String> letterCombinations(String digits) {

        Map<Integer, char []> num = new HashMap<>();

        num.put(2, new char [] {'a', 'b', 'c'});
        num.put(3, new char [] {'d', 'e', 'f'});
        num.put(4, new char [] {'g', 'h', 'i'});
        num.put(5, new char [] {'j', 'k', 'l'});
        num.put(6, new char [] {'m', 'n', 'o'});
        num.put(7, new char [] {'p', 'q', 'r', 's'});
        num.put(8, new char [] {'t', 'u', 'v'});
        num.put(9, new char [] {'w', 'x', 'y', 'z'});

        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans; // 엣지케이스: 비어있으면 미리 종료

        dfs(digits, 0, ans, new StringBuilder(), num);

        return ans;

    }

    private void dfs(String digits, int at, List<String> ans, StringBuilder sb, Map<Integer, char []> num){

        if(digits.length() == sb.length()){
            ans.add(sb.toString());
            return;
        }


        // for(int i=at; i<digits.length(); i++){
        //     int cur = digits.charAt(i) - '0'; // 주의! 여기서 char형이니까 int 형으로 바꾸려면 '0'을 빼줘야함
        //     System.out.print(cur);
        //     for(char c : num.get(cur)){
        //         sb.append(c);
        //         dfs(digits, i+1, ans, sb, num);
        //         sb.deleteCharAt(sb.length()-1);
        //     }
        // }

        int cur = digits.charAt(at) - '0'; // 주의! 여기서 char형이니까 int 형으로 바꾸려면 '0'을 빼줘야함
        for(char c : num.get(cur)){
            sb.append(c);
            dfs(digits, at+1, ans, sb, num);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    // // 방법2. 배열로 하기
    // public List<String> letterCombinations(String digits) {

    //     List<String> ans = new ArrayList<>();

    //     if(digits.length() == 0) return ans; // 엣지케이스: 비어있으면 미리 종료
    // String[] num = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    //     dfs(digits, 0, ans, new StringBuilder(), num);

    //     return ans;

    // }

    // private void dfs(String digits, int at, List<String> ans, StringBuilder sb, String[] num){

    //     if(digits.length() == sb.length()){
    //         ans.add(sb.toString());
    //         return;
    //     }

    //     String cur = num[digits.charAt(at)-'0'];

    //     for(char c : cur.toCharArray()){
    //         sb.append(c);
    //         dfs(digits, at+1, ans, sb, num);
    //         sb.deleteCharAt(sb.length()-1);
    //     }

    // }
}