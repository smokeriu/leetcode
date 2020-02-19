package _236_Lowest_Common_Ancestor_of_a_Binary_Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(exist(root.left,p,q) && exist(root.right,p,q)){
            return root;
        }else if(exist(root.left,p,q)){
            if(root.val == q.val || root.val == p.val){
                return root;
            }else{
                return lowestCommonAncestor(root.left,p,q);
            }

        }else{
            if(root.val == q.val || root.val == p.val){
                return root;
            }else{
                return lowestCommonAncestor(root.right,p,q);
            }
        }
    }
    public boolean exist(TreeNode root,TreeNode p , TreeNode q){
        if(root == null) return false;
        //System.out.println(root.val+","+p.val+","+q.val);
        return root.val == p.val || root.val == q.val || exist(root.left,p,q) || exist(root.right,p,q) ;
    }
}