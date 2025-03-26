/*
String [] -> List<String> 헷갈림
숫자 제외하는 정규 표현식 잘 모름. 공백 문자 제거 stream 숙지
*/
import java.util.*;
import java.util.stream.*;
class Solution {
    static List<List<String>> operOrder = new ArrayList<>();
    static String [] operator ={"*","-","+"};
    public long solution(String expression) {
        long max = 0;


        List<Long> num = Arrays.stream(expression.split("[\\+\\-\\*]")).map(i -> Long.parseLong(i)).collect(Collectors.toList());

        List<String> oper = Arrays.stream(expression.split("[0-9]+")).filter(s -> !s.isEmpty()).collect(Collectors.toList());

        perm(new ArrayList<>(), new boolean [3]);

        for(List<String> orders : operOrder){
            List<Long> tempNum = new ArrayList<>(num);
            List<String> tempOper = new ArrayList<>(oper);

            for(String o : orders){
                int cur = 0;
                while(cur < tempOper.size()){
                    int next = cur+1;
                    String curOper = tempOper.get(cur);

                    if(curOper.equals(o)){ // 연산자가 동일하면
                        long a = tempNum.get(cur);
                        long b = tempNum.get(next);
                        long c = getValue(a,b,o);
                        tempNum.set(cur, c);
                        tempNum.remove(next);
                        tempOper.remove(cur);
                    }else{
                        cur++;
                    }
                }
            }

            max = Math.max(max, Math.abs(tempNum.get(0)));

        }

        return max;
    }

    private static long getValue(long a, long b, String oper){
        if(oper.equals("*")){
            return a*b;
        }else if(oper.equals("+")){
            return a+b;
        }else{
            return a-b;
        }
    }

    private static void perm(List<String> num, boolean [] visited){
        if(num.size() == 3){
            operOrder.add(new ArrayList<>(num));
            return;
        }

        for(int i=0; i<3; i++){
            if(visited[i]) continue;
            visited[i] = true;
            num.add(operator[i]);
            perm(num, visited);
            visited[i] = false;
            num.remove(num.size()-1);
        }
    }
}