package _437_Path_Sum_III

//给定一个二叉树，它的每个结点都存放着一个整数值。
//
// 找出路径和等于给定数值的路径总数。
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
//
// 示例：
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
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
object SolutionV1 {
  def pathSum(root: TreeNode, sum: Int): Int = {
    find(root,sum,sum,true)
  }
  def find(root:TreeNode,sum:Int,origin:Int,isOrigin:Boolean):Int={
    if(root == null) return 0
    var count = 0
    if(root.value == sum){
      count += 1
      println(root.value)
    }
    count += find(root.left,sum-root.value,origin,false)
    count += find(root.right,sum-root.value,origin,false)
    if(sum == origin && isOrigin ){
      count += find(root.left,origin,origin,isOrigin)
      count += find(root.right,origin,origin,isOrigin)
    }

    count
  }
}
//leetcode submit region end(Prohibit modification and deletion)
