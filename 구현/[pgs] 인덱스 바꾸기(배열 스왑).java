class Solution {
    public String solution(String my_string, int num1, int num2) {
        char [] str = my_string.toCharArray();

        char temp = str[num1];
        str[num1] = str[num2];
        str[num2] = temp;

        return new String(str);
    }
}