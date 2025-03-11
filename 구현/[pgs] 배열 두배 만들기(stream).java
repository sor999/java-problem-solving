import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        numbers = Arrays.stream(numbers).map(i -> i*2).toArray();
        return numbers;
    }
}