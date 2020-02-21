package _216_Combination_Sum_III

//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
// 说明：
//
//
// 所有数字都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
//
//
// 示例 2:
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//
// Related Topics 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  def combinationSum3(k: Int, n: Int): List[List[Int]] = {
    val buffer = ListBuffer[List[Int]]()
    func(k,n,1,buffer,List[Int]())
    buffer.toList
  }
  def func(nextK:Int,n:Int,start:Int,buffer:ListBuffer[List[Int]],res:List[Int]): Unit ={
    if(nextK==0 && res.sum==n){
      buffer += res
    }else{
      for(i<-start to 9){
        if(res.sum+i>n){
          //eroor
          return
        }else if(res.sum+i == n && nextK!=1){
          return
        }else{
          func(nextK-1,n,i+1,buffer,res++List[Int](i))
        }
      }
    }
  }

}
//leetcode submit region end(Prohibit modification and deletion)

