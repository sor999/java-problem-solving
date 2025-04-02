import java.util.*;
class Solution {
    public String[] solution(String[] files) {

        List<Name> names = new ArrayList<>();

        for(String file : files){
            String head = "";
            String numberStr = "";
            String tail = "";

            int i = 0;
            while(i < file.length() && !Character.isDigit(file.charAt(i))) { // 처음 숫자를 찾는다.
                i++;
            }
            head = file.substring(0, i);

            int j = i;
            while(j < file.length() && Character.isDigit(file.charAt(j)) && (j-i) < 5) {
                j++;
            }
            numberStr = file.substring(i, j);
            int number = Integer.parseInt(numberStr);

            tail = file.substring(j);

            names.add(new Name(file, head, number, tail));
        }

        Collections.sort(names, (a,b) -> {
            int hDiff = a.head.toLowerCase().compareTo(b.head.toLowerCase());
            if(hDiff != 0) {
                return hDiff;
            }

            if(a.number != b.number) {
                return a.number - b.number;
            }

            return 0;
        });

        String [] ans = new String [names.size()];
        for(int a = 0; a<names.size(); a++){
            ans[a] = names.get(a).fullName;
        }
        return ans;
    }

    private static class Name{
        String fullName;
        String head;
        int number;
        String tail;

        public Name(String fullName, String head, int number, String tail){
            this.fullName = fullName;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

    }
}