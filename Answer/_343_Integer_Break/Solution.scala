package _343_Integer_Break

//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
//
// 示例 1:
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。
//
// 示例 2:
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。
// Related Topics 数学 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  def integerBreak(n: Int): Int = {
    val buffer = Array.fill(n+1)(-1)
    buffer(1) = 1
    for(i<-2 to n){
      for(j<-1 until i){
        buffer(i) = buffer(i).max( (j*(i-j)).max(j*buffer(i-j)) )
        println(buffer(i),i)
      }
    }
    //buffer.foreach(println)
    buffer.last
  }
}
//leetcode submit region end(Prohibit modification and deletion)

