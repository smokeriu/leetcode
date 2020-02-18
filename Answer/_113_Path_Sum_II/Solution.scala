package _113_Path_Sum_II

//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
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
  def pathSum2(root: TreeNode, sum: Int): List[List[Int]] = {
    if(root == null) return List[List[Int]]()
    if(root.left == null && root.right ==null && sum == root.value){
      // 满足条件的叶子节点
      return List[List[Int]](List[Int](root.value))
    }
    val left = pathSum(root.left,sum-root.value)
    val right = pathSum(root.right,sum-root.value)
    var res = left ++ right
    if(res.nonEmpty){
      res.map(r=>{
        List[Int](root.value) ++ r
      })
    }else{
      res.toList
    }
  }

  def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {
    val buffer = new scala.collection.mutable.ListBuffer[List[Int]]
    def impl(root: TreeNode, partialSum: Int, res: List[Int]): Unit = {
      (root.left, root.right) match {
        case (null, null) => {
          if(partialSum + root.value == sum)
            buffer.append(res :+ root.value)
        }
        case (null, right) => impl(root.right, partialSum + root.value, res :+ root.value)
        case (left, null) => impl(root.left, partialSum + root.value, res :+ root.value)
        case (left, right) =>
          impl(root.right, partialSum + root.value, res :+ root.value)
          impl(root.left, partialSum + root.value, res :+ root.value)
      }
    }
    if (root == null) Nil else {
      impl(root, 0, Nil)
      buffer.toList
    }
  }
}


//leetcode submit region end(Prohibit modification and deletion)

