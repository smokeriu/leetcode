package _90_Subsets_II

//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
// Related Topics 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    val buffer = ListBuffer[List[Int]]()
    val used = Array.fill(nums.length)(false)
    func(nums.sorted,0,used,buffer,List[Int]())
    buffer.toList
  }
  def func(nums:Array[Int],start:Int,used:Array[Boolean],buffer:ListBuffer[List[Int]],res:List[Int]): Unit ={
    buffer += res
    for(i<-start until nums.length){
      if(!((i-1)>=start && nums(i)==nums(i-1) && !used(i-1))){
        used(i)=true
        func(nums,i+1,used,buffer,res++List[Int](nums(i)))
        used(i)=false
      }
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)
