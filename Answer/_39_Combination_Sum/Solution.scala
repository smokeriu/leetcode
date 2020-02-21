package _39_Combination_Sum

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。
//
// 说明：
//
//
// 所有数字（包括 target）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
//
//
// 示例 2:
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// Related Topics 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    val buffer = HashSet[List[Int]]()
    func(candidates.sortBy(-_),target,buffer,List[Int](),0)
    buffer.toList
  }
  def func(candidates:Array[Int],remainder:Int,buffer:HashSet[List[Int]],res:List[Int],before:Int): Unit ={
    if(remainder==0){
      buffer += res.sorted
    }else if(remainder<0){
      // do nothing
    }else{
      for(i<-candidates){
        if(i<before){

        }else if(remainder-i>=0){
          func(candidates,remainder-i,buffer,res++List[Int](i),i)
        }
      }
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)

