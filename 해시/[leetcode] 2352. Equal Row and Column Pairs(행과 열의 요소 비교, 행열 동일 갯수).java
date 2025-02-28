/*
방법1. 배열돌리기 구현
행/열에 대한 시작 인덱스 를 놓고 행/열이 같은지 비교하자
O(n^2*(n) = n^3)

방법2. 해시태이블
행을 key로 map에 넣어둔다. value는 key와 동등한 행의 개수 -> n^2
- 해시 기반 collection들(정렬하는 것 제외)은 hashCode() -> equals() 로 비교를 한다.
열 List에 대해서 map에 키가 있는지 찾고 있으면 value를 ++ -> n^2
O(n^2)
*/
class Solution {
    //방법1. 배열돌리기 구현
    // public int equalPairs(int[][] grid) {
    //     int n = grid.length;
    //     int cnt = 0;

    //     for(int r=0; r<n; r++){
    //         for(int c=0; c<n; c++){
    //             boolean isValid = true; // 될거라 가정
    //             for(int k=0; k<n; k++){
    //                 if(grid[r][k] != grid[k][c]){
    //                     isValid = false; // 만약 일치하지 않는 것이 있다면 false
    //                     break;
    //                 }
    //             }
    //             if(isValid) cnt++;  // 전부 일치할 때만 ++
    //         }
    //     }
    //     return cnt;
    // }

    // 방법2. 해시 태이블
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int cnt = 0;

        Map<List<Integer>, Integer> map = new HashMap<>();

        //row에 대해 먼저 넣어주기
        for(int [] r : grid){
            List<Integer> temp = new ArrayList<>();
            for(int num : r){
                temp.add(num);
            }
            map.put(temp, map.getOrDefault(temp,0)+1);
        }

        //c에 대해 넣어주기
        for(int c=0; c<n; c++){
            List<Integer> temp = new ArrayList<>();
            for(int k=0; k<n; k++){
                temp.add(grid[k][c]);
            }
            cnt += map.getOrDefault(temp, 0); // map에 존재한다는 것은 행이 있다는 것. 행의 갯수를 넣어준다.
        }
        return cnt;
    }
}