package _78_Subsets

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics 位运算 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    val buffer = ListBuffer[List[Int]]()
    //        val used = Array.fill(nums.length)(false)
    func(nums,0,List[Int](),buffer)
    buffer.toList
  }
  def func(nums:Array[Int],start:Int,res:List[Int],buffer:ListBuffer[List[Int]]): Unit ={
    buffer += res
    for(i<-start until nums.length){
      func(nums,i+1,res++List[Int](nums(i)),buffer)
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)
