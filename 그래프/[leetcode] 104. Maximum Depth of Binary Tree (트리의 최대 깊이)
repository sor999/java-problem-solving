/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
O(n), dfs
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
    // 방법 1.
    // public int maxDepth(TreeNode root) {
    //     return dfs(root);
    // }
    // public static int dfs(TreeNode cur){
    //     int cntL = 1;
    //     int cntR = 1;


    //     if(cur == null) return 0;

    //     if(cur.left != null) cntL += dfs(cur.left);
    //     if(cur.right != null) cntR += dfs(cur.right);
        
    //     return Math.max(cntL, cntR);
    // }

    // 방법 2.
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
