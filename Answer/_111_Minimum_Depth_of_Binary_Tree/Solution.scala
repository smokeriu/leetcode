package _111_Minimum_Depth_of_Binary_Tree

//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
// Related Topics 树 深度优先搜索 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def minDepth(root: TreeNode): Int = {
    if(root == null) return 0
    if ((root.left == null) && (root.right == null)) return 1
    var res = Int.MaxValue
    if(root.left != null){
      res = res.min(minDepth(root.left))
    }
    if(root.right != null){
      res = res.min(minDepth(root.right))
    }
    res+1
  }
}
//leetcode submit region end(Prohibit modification and deletion)

