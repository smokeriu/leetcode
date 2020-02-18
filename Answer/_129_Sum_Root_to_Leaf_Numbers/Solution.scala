package _129_Sum_Root_to_Leaf_Numbers

import _112_Path_Sum.TreeNode
//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。
//
// 计算从根到叶子节点生成的所有数字之和。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例 1:
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25.
//
// 示例 2:
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026.
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
  def sumNumbers(root: TreeNode): Int = {
    val res = func(root)
    var sum = 0
    for(i<-res){
      println(i)
      sum += i.toInt
    }
    sum

  }
  // 拿到所有路径组成的数字,由于结果是int，应该不会越界
  def func(root:TreeNode):List[String]={
    if(root == null) return List.empty
    var buffer = ListBuffer[String]()
    (root.left,root.right) match {
      // 叶子节点
      case (null,null) => return List[String](root.value.toString)
      case (null,right) => buffer ++= func(root.right)
      case (left,null) => buffer ++= func(root.left)
      case (left,right) => buffer ++= (func(root.left)++func(root.right))
    }
    if(buffer.nonEmpty){
      buffer.map(x=>{
        root.value + x
      }).toList
    }else{
      List.empty
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)

