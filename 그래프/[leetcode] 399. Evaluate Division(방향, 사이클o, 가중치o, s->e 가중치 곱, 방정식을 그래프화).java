/*
--- 처음 생각
모르는 문자 있는지 확인 -> 있으면 바로 -1
a-> c로 변경하기.
a = ~b = ~c ...
b = ~a = ~c...
c = ~a = ~b
일테니까


모든 문자를 a로 나타내보자 -> abcd/efg 이렇게 되면 a로 나타내도 의미 없지 않을까

1. 약분 과정
bc/cd 처리 -> 위의 알파벳 개수 구하고, 밑의 알파벳 개수 구한다. 위 , 아래 중 하나만 0이면 다른 알파벳으로 바꾼다.

2. a/bc = ? 이면 a=bc*? 일텐데 이건 어떻게 처리할까
길이를 짧은 것 부터 정렬해서 해야하는가 -> 그러면 일단 최대한 아는 알파벳을 먼저 찾고, 그 다음에 식에 대입할 수 있지 않을까?
Map에 a : 2b... 이런식으로 정리해서. value 를 char로 쪼개고 곱셈으로 연결. 이걸로 위를 변경했을 때 위 아래의 특정 알파벳 개수랑 같아지면 멈추기 달라지면 2b에서 한번 더 가기. b : ? 이런 식으로

그리고 지금까지 방정식에 등장했던 모든 문제에 대하여 set에 저장해서 나중에 쿼리에서 검사하자(visited)

--- 답
방정식을 그래프화 한다.

알파벳은 노드가 되고, 계수는 방향 그래프의 가중치가 된다.
이때 계수를 역수로 취하면 반대방향 가중치인 것

a -- 2 --> b -- 3 --> c
a <-- 1/2 -- b <-- 1/3 -- c

내가 고민했던 것은 bc를 어떻게 쪼개서 약분하고 계산할 것인가 였는데, 그럴 필요가 없다. 문제에서 bc != b*c이기 때문이다.

tc: O(n*queryes.size)

*/
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String,Double>> g = new HashMap<>(); // 노드 s  -> 노드 e, 가중치

        for(int i=0; i<equations.size(); i++){
            String s = equations.get(i).get(0);
            String e = equations.get(i).get(1);

            // 시작점 넣기
            g.putIfAbsent(s, new HashMap<>()); // 존재 안하면 초기화 먼저 해주기
            g.get(s).put(e, values[i]);
            // 끝점 넣기
            g.putIfAbsent(e, new HashMap<>());
            g.get(e).put(s, 1/values[i]);
        }

        double[] ans = new double[queries.size()];

        for(int i=0; i<queries.size(); i++){
            ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), g);
        }

        return ans;
    }


    private double dfs(String s, String e, Set<String> visited, Map<String, Map<String,Double>> g){
        if(!g.containsKey(s)){ // 이 g에 존재하지 않는 알파벳(노드)는 결국 -1
            return -1.0;
        }

        if(g.get(s).containsKey(e)){ // s->e로의 방향이 있다면
            return g.get(s).get(e); // 그때의 가중치
        }

        visited.add(s); // 방문 체크

        for(Map.Entry<String, Double> nexts : g.get(s).entrySet()){ // s로 시작하는 노드에 대해 다음 노드+가중치
            if(visited.contains(nexts.getKey())) continue; // 만약 이미 e에 해당하는 알파벳을 가지고 있다면 가지 말기
            double weight = dfs(nexts.getKey(), e, visited, g); // 만약 아직 해당 알파벳이 없다면 넣어주기
            if(weight != -1.0) return nexts.getValue()*weight; // 재귀적으로 (다음노드가중치*현재까지가중치)를 한다. -1이 존재하면 안되는 알파벳이 반드시 포함되어있으니까 -1이 루트 노드까지 전파되어야 해서 if문을 써줘서 예외처리. 아니면 바로 반환.
        }
        return -1.0; // 탐색 중에 모르는 알파벳이 있으면 계속 -1이 반환되어야 한다.
    }

}