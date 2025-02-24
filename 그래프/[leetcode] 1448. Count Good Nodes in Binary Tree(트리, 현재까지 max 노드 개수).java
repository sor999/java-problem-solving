
/*
다음 노드의 값 >= 현재 노드 값 일때만 +1
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
    public int goodNodes(TreeNode root) {

        // return dfs(root, root.val);
        return bfs(root);
    }

    private int dfs(TreeNode root, int max){ // 재귀
        if(root == null) return 0;

        max = Math.max(root.val, max);

        if(root.val >= max){
            return 1 + dfs(root.left, max) + adfs(root.right, max);
        }else{
            return dfs(root.left, max) + dfs(root.right, max);
        }
    }
}