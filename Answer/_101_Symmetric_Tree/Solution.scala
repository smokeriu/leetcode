package _101_Symmetric_Tree

//给定一个二叉树，检查它是否是镜像对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
// 说明:
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
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

import scala.collection.mutable._
object Solution {
  def isSymmetric(root: TreeNode): Boolean = {
    if(root ==null) return true
    val queue = Queue[TreeNode]()
    queue.enqueue(root.left)
    queue.enqueue(root.right)
    while(queue.nonEmpty){
      val left = queue.dequeue()
      val right = queue.dequeue()
      if(left==null && right == null){
        // do nothing
      }else if(left==null || right == null){
        return false
      }else if(left.value != right.value){
        return false
      }else{
        queue.enqueue(left.left)
        queue.enqueue(right.right)
        queue.enqueue(left.right)
        queue.enqueue(right.left)
      }
    }
    true
  }
}
//leetcode submit region end(Prohibit modification and deletion)

