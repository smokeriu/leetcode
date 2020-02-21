package _47_Permutations_II

//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例:
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  def permuteUnique(nums: Array[Int]): List[List[Int]] = {
    if(nums == null) return List.empty
    val used = HashMap[Int,Boolean]()
    val buffer = ListBuffer[List[Int]]()
    val usedArr = Array.fill(nums.length)(false)
    func(nums.sorted,usedArr,buffer,List[Int](),0)
    buffer.toList
  }
  def func(nums:Array[Int],usedArr:Array[Boolean],buffer:ListBuffer[List[Int]],res:List[Int],index:Int):Unit={
    if(index == nums.length){
      buffer += res
    }else{
      for(i<-nums.indices){
        //println(res.mkString(":"),nums(i))
        if(!usedArr(i)){
          if(!(i > 0 && nums(i) == nums(i - 1) && !usedArr(i - 1))){
            usedArr(i) = true
            func(nums,usedArr,buffer,res++List[Int](nums(i)),index+1)
            usedArr(i) = false
          }
        }
      }
    }
  }
}

//leetcode submit region end(Prohibit modification and deletion)

