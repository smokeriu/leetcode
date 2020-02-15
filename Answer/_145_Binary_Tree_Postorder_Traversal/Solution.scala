package _145_Binary_Tree_Postorder_Traversal

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
  def postorderTraversal(root: TreeNode): List[Int] = {
    val stack = Stack[TreeNode]()
    val res = ListBuffer[Int]()
    if(root==null) return res.toList
    var temp = root
    while(temp != null || stack.nonEmpty) {
      if (temp != null) {
        res.+=:(temp.value)
        stack.push(temp)
        temp = temp.right
      } else {
        val node = stack.pop()
        temp = node.left
      }
    }
    res.toList
  }
}
//leetcode submit region end(Prohibit modification and deletion)
