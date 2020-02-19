package _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

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
        if(p.val==root.val || q.val==root.val){
            return root;
        }
        if( p.val < root.val && q.val > root.val ){
            return root;
        }
        if( p.val > root.val && q.val < root.val ){
            return root;
        }
        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return lowestCommonAncestor(root.right,p,q);
        }
    }
}