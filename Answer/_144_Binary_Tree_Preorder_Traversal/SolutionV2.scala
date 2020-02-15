package _144_Binary_Tree_Preorder_Traversal

//给定一个二叉树，返回它的 前序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,2,3]
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树


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

object SolutionV2 {
  def preorderTraversal(root: TreeNode): List[Int] = {
    if(root==null) return List[Int]()
    val res = ListBuffer[Int]()
    val stack = Stack[TreeNode]()
    stack.push(root)
    while(stack.nonEmpty){
      val tmp = stack.pop()
      res += tmp.value
      if(tmp.right!=null)
        stack.push(tmp.right)
      if(tmp.left!=null)
        stack.push(tmp.left)
    }
    res.toList
  }
}
//leetcode submit region end(Prohibit modification and deletion)
