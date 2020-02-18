package _404_Sum_of_Left_Leaves

//计算给定二叉树的所有左叶子之和。
//
// 示例：
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// Related Topics 树


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
  def sumOfLeftLeaves(root: TreeNode): Int = {
    if(root == null) return 0
    var left = 0
    if(root.left != null){
      left = func(root.left,true)
    }
    var right = 0
    if(root.right != null){
      right = func(root.right,false)
    }
    left + right
  }
  def func(root:TreeNode,isLeft:Boolean): Int ={
    if(root.left == null && root.right==null && isLeft) return root.value

    var left = 0
    if(root.left != null){
      left = func(root.left,true)
    }
    var right = 0
    if(root.right != null){
      right = func(root.right,false)
    }
    left + right
  }
}
//leetcode submit region end(Prohibit modification and deletion)

