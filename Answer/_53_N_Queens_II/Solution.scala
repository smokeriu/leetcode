package _53_N_Queens_II

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
//
// 示例:
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  var cols :Array[Boolean] = _
  var dia1 :Array[Boolean] = _
  var dia2 :Array[Boolean] = _
  def totalNQueens(n: Int): Int = {
    if(n==0) return 0
    cols = Array.fill(n)(false)
    dia1 = Array.fill(2*n-1)(false)
    dia2 = Array.fill(2*n-1)(false)
    var count = 0

    return find(0,n,count)
  }
  def find(x:Int,n:Int,count_ :Int): Int ={
    var count = count_
    if(x == n){
      count += 1
    }else{
      for(y<-0 until n){
        if(!cols(y) && !dia1(x+y) && !dia2(x-y+n-1)){
          cols(y) = true
          dia1(x+y) = true
          dia2(x-y+n-1) = true
          count = find(x+1,n,count)
          cols(y) = false
          dia1(x+y) = false
          dia2(x-y+n-1) = false
        }
      }
    }
    count
  }
}
//leetcode submit region end(Prohibit modification and deletion)

