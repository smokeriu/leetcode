package _64_Minimum_Path_Sum
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
// 示例:
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
//
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  def minPathSum(grid: Array[Array[Int]]): Int = {
    val help = Array.fill(grid.length)(Array.fill(grid(0).length)(Int.MaxValue))
    help(help.length-1)(help.last.length-1) = grid.last.last
    for(x<-help.indices.reverse){
      for(y<-help(x).indices.reverse){
        if(y+1<=help(x).length-1){
          val right = help(x)(y+1) + grid(x)(y)
          help(x)(y) = help(x)(y).min(right)
        }
        if(x+1<=help.length-1){
          val down = help(x+1)(y) + grid(x)(y)
          help(x)(y) = help(x)(y).min(down)
        }
      }
    }
    help.head.head
  }
}
//leetcode submit region end(Prohibit modification and deletion)

