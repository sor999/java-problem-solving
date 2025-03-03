/*
이전 상태를 저장하고 있어야 오 -> 왼이 됨.
2개의 값으로 -> boolean

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

    // 방법1.
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return max;
    }

    public void dfs(TreeNode cur, boolean prevDir, int cnt){
        if(cur == null) return;
        max = Math.max(max, cnt);
        if(!prevDir){
            dfs(cur.left, !prevDir, cnt+1);
            dfs(cur.right, prevDir, 1);
        }else{
            dfs(cur.right, !prevDir, cnt+1);
            dfs(cur.left, prevDir, 1);
        }
    }


    // // 방법 2. 루트를 왼/오 가정(루트부터 도니까 더 느림)
    // int max = 0;
    // public int longestZigZag(TreeNode root) {
    //     if(root == null) return 0;
    //     dfs(root, true, 0);
    //     dfs(root, false, 0);
    //     return max;
    // }

    // public void dfs(TreeNode cur, boolean prevDir, int cnt){
    //     if(cur == null) return;
    //     max = Math.max(max, cnt);
    //     if(!prevDir){
    //         dfs(cur.left, !prevDir, cnt+1);
    //         dfs(cur.right, prevDir, 1);
    //     }else{
    //         dfs(cur.right, !prevDir, cnt+1);
    //         dfs(cur.left, prevDir, 1);
    //     }
    // }

}