package _279_Perfect_Squares

//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
// 示例 1:
//
// 输入: n = 12
//输出: 3
//解释: 12 = 4 + 4 + 4.
//
// 示例 2:
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9.
// Related Topics 广度优先搜索 数学 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  def numSquares(n: Int): Int = {
    if(n<=1) return 1
    val buffer = Array.fill(n+1)(Int.MaxValue)
    buffer(0) = 0
    buffer(1) = 1
    for(i<-2 to n){
      for(j<- 1 to Math.sqrt(i).toInt){
        buffer(i) = buffer(i).min(1 + buffer(i-Math.pow(j,2).toInt))
      }
    }
    buffer.last
  }

}
//leetcode submit region end(Prohibit modification and deletion)

