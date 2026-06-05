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
    public boolean isSameTree(TreeNode p, TreeNode q) {
    Stack<TreeNode> stack = new Stack<>();
    stack.push(p);
    stack.push(q);
    
    while (!stack.isEmpty()) {
        TreeNode n1 = stack.pop();
        TreeNode n2 = stack.pop();
        
        if (n1 == null && n2 == null) continue;
        if (n1 == null || n2 == null) return false;
        if (n1.val != n2.val) return false;
        
        stack.push(n1.left);
        stack.push(n2.left);
        stack.push(n1.right);
        stack.push(n2.right);
    }
    
    return true;
    }
}
