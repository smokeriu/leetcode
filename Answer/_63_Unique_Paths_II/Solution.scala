package _63_Unique_Paths_II

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
//
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。
//
// 说明：m 和 n 的值均不超过 100。
//
// 示例 1:
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
//
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
object Solution {
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
    if(obstacleGrid.length==0) return 0
    val arr = Array.fill(obstacleGrid.length)(Array.fill(obstacleGrid(0).length)(0))
    for(x<-arr.indices){
      for(y<-arr(x).indices){
        if(obstacleGrid(x)(y) == 1 ){
          arr(x)(y) = 0
        }else if(x==0 && y==0){
          arr(x)(y) = 1 // start
        }else if(x==0 || y==0) {
          arr(x)(y) = if (x == 0) arr(x)(y - 1) else arr(x - 1)(y) //line
        }else{
          arr(x)(y) = arr(x-1)(y) + arr(x)(y-1)
        }
      }
    }
    for (elem <- arr) {println(elem.mkString(","))}
    arr.last.last
  }
}
//leetcode submit region end(Prohibit modification and deletion)


