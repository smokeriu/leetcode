package _120_Triangle

//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 例如，给定三角形：
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
// 说明：
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object SolutionV1 {
  var buffer:Buffer[Buffer[Int]] =_
  def minimumTotal(triangle: List[List[Int]]): Int = {
    buffer = triangle.map(list=>{list.map(x=>{-1}).toBuffer}).toBuffer
    func(0,0,triangle,buffer)
  }
  def func(x:Int,y:Int,triangle:List[List[Int]],buffer:Buffer[Buffer[Int]]):Int={
    if(x == triangle.length-1){
      //遍历到底
      triangle(x)(y)
    }else{
      if(buffer(x)(y) == -1){
        val left = func(x+1,y,triangle,buffer)+
        val right = func(x+1,y+1,triangle,buffer)
        buffer(x)(y) = left.min(right)
      }
      triangle(x)(y) + buffer(x)(y)
    }

  }
  def check(x:Int,y:Int,xLen:Int,yLen:Int):Boolean={
    true
  }

}
//leetcode submit region end(Prohibit modification and deletion)

