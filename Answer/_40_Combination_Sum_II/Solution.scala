package _40_Combination_Sum_II

//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。
//
// 说明：
//
//
// 所有数字（包括目标数）都是正整数。
// 解集不能包含重复的组合。
//
//
// 示例 1:
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//
//
// 示例 2:
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//]
// Related Topics 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] = {
    val buffer = HashSet[List[Int]]()
    val used = Array.fill(candidates.length)(false)
    func(candidates.sorted,target,buffer,List[Int](),0,used)
    buffer.toList
  }
  def func(candidates:Array[Int],target:Int,buffer:HashSet[List[Int]],res:List[Int],start:Int,used:Array[Boolean]): Unit ={
    if(target == 0){
      //println(res.mkString(","))
      buffer += res
    }else{
      for(i<-start until candidates.length){
        if( !(i>0 && candidates(i) == candidates(i-1) && !used(i-1)) ) {
          if(target-candidates(i)>=0) {
            used(i) = true
            func(candidates, target - candidates(i), buffer, res ++ List[Int](candidates(i)), i + 1, used)
            used(i) = false
          }
        }
      }
    }
  }
}

//leetcode submit region end(Prohibit modification and deletion)

