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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
   String tree1 = serialize(root);
    String tree2 = serialize(subRoot);
    
    return tree1.contains(tree2);
}

private String serialize(TreeNode node) {
    if (node == null) return "null,";
    
    return node.val + "," +
           serialize(node.left) +
           serialize(node.right);
}
}
