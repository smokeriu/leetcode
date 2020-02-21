package _46_Permutations

//给定一个没有重复数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  def permute(nums: Array[Int]): List[List[Int]] = {
    if(nums == null) return List.empty
    val buffer = ListBuffer[List[Int]]()
    func(nums,List[Int](),buffer)
    buffer.toList
  }

  def func(nums:Array[Int],res:List[Int],buffer:ListBuffer[List[Int]]):Unit={
    if(nums.length == 0){
      buffer += res
    }else{
      for(i<-nums){
        func(nums.diff(Array[Int](i )),res++List[Int](i),buffer)
      }
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)
