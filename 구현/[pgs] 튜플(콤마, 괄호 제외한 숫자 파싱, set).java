/*

replce 사용하면 파싱 간단.
 */

import java.util.*;
import java.util.stream.*;
class Solution {
    public List<Integer> solution(String s) {

        String[] str = s.replaceAll("[{}]", " ").trim().split(" , ");
        Arrays.sort(str, (a, b)-> a.length() - b.length());

        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for(String cur : str){
            List<Integer> num = Arrays.stream(cur.split(",")).map(i -> Integer.parseInt(i)).collect(Collectors.toList());
            for(int v : num){
                if(!set.contains(v)){
                    ans.add(v);
                    set.add(v);
                    break;
                }
            }
        }

        return ans;
    }
    static List<List<Integer>> getTuple(String s){

        List<List<Integer>> tuple = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            String cur = s.charAt(i) + "";
            if(cur.equals("{")){
                continue;
            }
            else if(cur.equals("}")){
                if(sb.length() > 0) {
                    temp.add(Integer.parseInt(sb.toString()));
                    sb = new StringBuilder();
                }
                if(!temp.isEmpty()) {
                    tuple.add(new ArrayList<>(temp));
                }
                temp = new ArrayList<>();

            }else if(cur.equals(",")){
                if(sb.length() > 0) {
                    temp.add(Integer.parseInt(sb.toString()));
                    sb = new StringBuilder();
                }
            }else{
                sb.append(cur);
            }
        }
        return tuple;
    }

}

import java.util.*;
class Solution {
    public List<Integer> solution(String s) {

        List<List<Integer>> tuple = getTuple(s);

        Collections.sort(tuple, (a, b) -> a.size() - b.size());

        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for(List<Integer> list : tuple){
            for(int v : list){
                if(!set.contains(v)){
                    ans.add(v);
                    set.add(v);
                    break;
                }
            }

            set.addAll(list);
        }
        return ans;
    }
    static List<List<Integer>> getTuple(String s){

        List<List<Integer>> tuple = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            String cur = s.charAt(i) + "";
            if(cur.equals("{")){
                continue;
            }
            else if(cur.equals("}")){
                if(sb.length() > 0) {
                    temp.add(Integer.parseInt(sb.toString()));
                    sb = new StringBuilder();
                }
                if(!temp.isEmpty()) {
                    tuple.add(new ArrayList<>(temp));
                }
                temp = new ArrayList<>();

            }else if(cur.equals(",")){
                if(sb.length() > 0) {
                    temp.add(Integer.parseInt(sb.toString()));
                    sb = new StringBuilder();
                }
            }else{
                sb.append(cur);
            }
        }
        return tuple;
    }

}

