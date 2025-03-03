/*
dfs
시작점 도는 외부 dfs
합을 구하기 위한 내부 dfs
    합이 8이 넘으면 return? -> 음수도 됨.
    +-+ 해서 다시 원상복구 가능하므로 중간에 가지치기x
O(n*n)
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 방법1. O(n^2)
    // public int pathSum(TreeNode root, int targetSum) {
    //     if(root == null) return 0;
    //     return dfs(root, targetSum, 0) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    // }



    // public int dfs(TreeNode cur, long targetSum, long sum){
    //     if(cur == null) return 0;

    //     sum += cur.val;
    //     int cnt = 0;
    //     if(sum == targetSum) cnt = 1;
    //     else cnt = 0;

    //     cnt += dfs(cur.left, targetSum, sum) + dfs(cur.right, targetSum, sum);

    //     return cnt;
    // }
    // 방법 2. 백트래킹 - 해쉬맵
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> preSum = new HashMap<>();
        preSum.put(0L,1);
        return dfs(root, 0, targetSum, preSum);
    }

    public int dfs(TreeNode root, long curSum, int target, HashMap<Long, Integer> preSum){
        if(root == null) return 0;

        curSum += root.val; // 현재 노드 값 추가
        int cnt =  preSum.getOrDefault(curSum - target,0);

        preSum.put(curSum, preSum.getOrDefault(curSum,0)+1);

        // 다음 노드 파악
        cnt += dfs(root.left, curSum, target, preSum);
        cnt += dfs(root.right, curSum, target, preSum);

        preSum.put(curSum, preSum.get(curSum)-1); // 값 빼기

        if(preSum.get(curSum) == 0) preSum.remove(curSum);

        return cnt;
    }
    // // 방법 3. 외부에 변수 선언
    // int total = 0;
    // public int pathSum(TreeNode root, int targetSum) {
    //     if(root == null) return 0;
    //     dfs(root, targetSum, 0);
    //     pathSum(root.left, targetSum);
    //     pathSum(root.right, targetSum);
    //     return total;
    // }

    // public void dfs(TreeNode root, long targetSum, long cur){
    //     if(root == null) return;

    //     cur += root.val;
    //     if(cur == targetSum) total++;
    //     dfs(root.left, targetSum, cur);
    //     dfs(root.right, targetSum, cur);
    // }
}