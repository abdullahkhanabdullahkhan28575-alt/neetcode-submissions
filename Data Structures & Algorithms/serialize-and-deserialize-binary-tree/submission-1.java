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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "#";

        }
            return root.val+","
            +serialize(root.left)+","
            +serialize(root.right);

        
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] values=data.split(",");
        int [] index={0};
        return buildTree(values,index);

        
    }
    private TreeNode buildTree(String[] values, int [] index){
        String value=values[index[0]];
        index[0]++;
        if(value.equals("#")){
            return null;
        }

        TreeNode root =new 
        TreeNode(Integer.parseInt(value));
            root.left=buildTree(values,index);
            root.right=buildTree(values,index);
            return root ;

        }
    }

