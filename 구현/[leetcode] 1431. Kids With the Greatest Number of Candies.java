/*
배열에서 특정 값을 추가로 더했을 때 가장 큰 값인지 찾기
항상 max 값만 확인하면 되므로 max를 미리 저장해 놓자.
O(n)
*/
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        /* 방법 1 완탐 O(n^2)
        List<Boolean> result = new ArrayList<>();

        for(int i=0; i<candies.length; i++){
            int cur = candies[i] + extraCandies;
            boolean isGNum = true;
            for(int j=0; j<candies.length;j++){
                if(i==j) continue;
                if(cur < candies[j]){
                    isGNum = false;
                    break;
                }
            }
            if(isGNum) result.add(true);
            else result.add(false);
        }

        return result;
        */
        
        // 방법 2. max값을 미리 저장 O(n)
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for(int v : candies){
            max = Math.max(v, max);
        }

        for(int v : candies){
            boolean isGNum = v + extraCandies >= max;
            result.add(isGNum);
        }
        return result;
    }
}
