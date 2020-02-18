package _257_Binary_Tree_Paths

//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
// Related Topics 树 深度优先搜索


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
  def binaryTreePaths(root: TreeNode): List[String] = {
    if(root == null) return List[String]()
    if(root.left == null && root.right == null){
      // 叶子
      return List[String](root.value.toString)
    }

    val left = binaryTreePaths(root.left)
    val right = binaryTreePaths(root.right)

    val list = new ListBuffer[String]()
    for(i<-left){
      list += (root.value.toString + "->" +  i)
    }
    for(i<-right){
      list += (root.value.toString + "->" +  i)
    }
    list.toList
  }
}
//leetcode submit region end(Prohibit modification and deletion)

