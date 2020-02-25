package _213_House_Robber_II

//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
//装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
//
// 示例 1:
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
//
//
// 示例 2:
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
  // f(n) = sum(2~n-1) , v(n)+sum(2~n-2) , v(1)+sum2(3~n-1)
  // 先不去考虑循环，算出不循环的清空。
  def rob(nums: Array[Int]): Int = {
    if(nums.length==0) return 0
    if(nums.length<=3) return nums.max
    val arr = new Array[Int](nums.length)
    arr(1) = nums(1)
    arr(2) = arr(1).max(nums(2))
    for(i<-3 until arr.length){
      arr(i) = arr(i-1).max(arr(i-2)+nums(i))
    }
    val arr2 = new Array[Int](nums.length)
    arr2(2) = nums(2)
    arr2(3) = arr2(2).max(nums(3))
    for(i<-4 until arr2.length){
      arr2(i) = arr2(i-1).max(arr2(i-2)+nums(i))
    }
    //println(arr2.mkString(","))
    max3( arr(nums.length-2),nums.last+arr(nums.length-3), nums(0) + arr2(nums.length-2)  )
  }
  def max3(x:Int,y:Int,z:Int):Int={
    //println(x,y,z)
    x.max(y.max(z))
  }
}
//leetcode submit region end(Prohibit modification and deletion)
