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

public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode node,
                              StringBuilder sb) {

        if (node == null) {
            sb.append("#,");
            return;
        }

        sb.append(node.val).append(",");

        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }

    public TreeNode deserialize(String data) {

        String[] nodes = data.split(",");
        int[] index = new int[1];

        return dfsDeserialize(nodes, index);
    }

    private TreeNode dfsDeserialize(String[] nodes,
                                    int[] index) {

        String val = nodes[index[0]++];

        if (val.equals("#")) {
            return null;
        }

        TreeNode root =
                new TreeNode(Integer.parseInt(val));

        root.left = dfsDeserialize(nodes, index);
        root.right = dfsDeserialize(nodes, index);

        return root;
    }
}
