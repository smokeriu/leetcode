package _337_House_Robber_III

//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
//
// 示例 1:
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \
//     3   1
//
//输出: 7
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
//
// 示例 2:
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
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
object SolutionV1 {
  // f(root) = max(  v(root) + f(root.left.left)*4(left and right) , f(root.left)+f(root.right)      )
  val map = HashMap[TreeNode,Int]()
  def rob(root: TreeNode): Int = {
    func(root)
  }
  def func(root:TreeNode):Int={
    if(root==null) return 0
    if(map.contains(root)){
      return map(root)
    }
    var hadRoot = root.value
    var noRoot = 0
    if(root.left != null){
      hadRoot += func(root.left.left)
      hadRoot += func(root.left.right)
      noRoot += func(root.left)
    }
    if(root.right != null){
      hadRoot += func(root.right.right)
      hadRoot += func(root.right.left)
      noRoot += func(root.right)
    }
    val res = hadRoot.max(noRoot)
    map.put(root,res)
    res
  }
}
//leetcode submit region end(Prohibit modification and deletion)

