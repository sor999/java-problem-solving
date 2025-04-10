
class Solution {
    public int solution(String my_string) {

        String [] str = my_string.split(" ");

        int sum = Integer.parseInt(str[0]); // 항상 홀수개이기 때문에 처음에 저장 먼저하면 편할 것.
        for(int i=1; i<str.length; i+=2){
            String oper = str[i];
            int b = Integer.parseInt(str[i+1]);
            sum += oper.equals("+") ? b : -b;
        }
        return sum;

    }
}