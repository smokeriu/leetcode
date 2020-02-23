package _52_N_Queens


//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
// 示例:
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  var cols :Array[Boolean] = _
  var dia1 :Array[Boolean] = _
  var dia2 :Array[Boolean] = _
  def solveNQueens(n: Int): List[List[String]] = {
    if(n==0) return List.empty
    cols = Array.fill(n)(false)
    dia1 = Array.fill(2*n-1)(false)
    dia2 = Array.fill(2*n-1)(false)
    val buffer = ListBuffer[List[String]]()

    find(0,n,buffer,List[Int]())

    buffer.toList
  }
  def find(x:Int,n:Int,buffer:ListBuffer[List[String]],res:List[Int]): Unit ={
    if(res.length == n){
      val tmp = ListBuffer[String]()
      for(row<-0 until n){
        var str = ""
        for(col<-0 until n){
          if(col==res(row)){
            str += "Q"
          }else{
            str += "."
          }
        }
        tmp += str
      }
      buffer += tmp.toList
    }else{
      for(y<-0 until n){
        if(!cols(y) && !dia1(x+y) && !dia2(x-y+n-1)){
          cols(y) = true
          dia1(x+y) = true
          dia2(x-y+n-1) = true
          find(x+1,n,buffer,res++List[Int](y))
          cols(y) = false
          dia1(x+y) = false
          dia2(x-y+n-1) = false
        }
      }
    }
    return
  }
}
//leetcode submit region end(Prohibit modification and deletion)

