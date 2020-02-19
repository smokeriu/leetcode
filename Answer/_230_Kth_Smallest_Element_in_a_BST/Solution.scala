package _230_Kth_Smallest_Element_in_a_BST

//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
//
// 说明：
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
//
// 示例 1:
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1
//
// 示例 2:
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3
//
// 进阶：
//如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
// Related Topics 树 二分查找


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
  def kthSmallest(root: TreeNode, k: Int): Int = {
    if(root==null) return 0
    val x = nodeCount(root.left)
    if(x + 1 == k ){
      root.value
    }else if (x + 1 < k){
      kthSmallest(root.right,k-x-1)
    }else{
      kthSmallest(root.left,k)
    }
  }
  def nodeCount(root:TreeNode):Int={
    if(root == null) return 0
    1 + nodeCount(root.left) + nodeCount(root.right)
  }


}
//leetcode submit region end(Prohibit modification and deletion)

