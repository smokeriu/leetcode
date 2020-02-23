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
object SolutionV2 {
  var arr:Array[Int]=_
  def numSquares(n: Int): Int = {
    arr = Array.fill(n+1)(-1)
    func(n)
  }
  def func(n:Int):Int={
    if( arr(n) != -1 ) return arr(n)
    var res = Int.MaxValue
    if(Math.sqrt(n)==Math.sqrt(n).toInt.toDouble) {
      arr(n) = 1
      return arr(n)
    }
    for(i<-1 to Math.sqrt(n).toInt){
      res = res.min(1+func(n-i*i))
    }
    arr(n) = res
    res
  }

}
//leetcode submit region end(Prohibit modification and deletion)
