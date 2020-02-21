package _77_Combinations

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  def combine(n: Int, k: Int): List[List[Int]] = {
    val buffer = ListBuffer[List[Int]]()
    func(n,k,1,List[Int](),buffer)
    buffer.toList
  }
  def func(n:Int,k:Int,start:Int,res:List[Int],buffer:ListBuffer[List[Int]]): Unit ={
    if(res.length == k) {
      buffer += res
    }else{
      for(i<- start to (n - (k-res.size) + 1)  ){
        func(n,k,i+1,res++List[Int](i),buffer)
      }
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)

