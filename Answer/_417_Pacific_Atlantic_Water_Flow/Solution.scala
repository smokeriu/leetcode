package _417_Pacific_Atlantic_Water_Flow

//给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
//
// 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
//
// 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
//
//
//
// 提示：
//
//
// 输出坐标的顺序不重要
// m 和 n 都小于150
//
//
//
//
// 示例：
//
//
//
//
//给定下面的 5x5 矩阵:
//
//  太平洋 ~   ~   ~   ~   ~
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
//
//返回:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
//
//
//
// Related Topics 深度优先搜索 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  val pos = Array[(Int,Int)]( (1,0),(-1,0),(0,1),(0,-1) )
  def pacificAtlantic(matrix: Array[Array[Int]]): List[List[Int]] = {
    val buffer = ListBuffer[List[Int]]()
    var visit = Array.fill(matrix.length)(Array.fill(matrix(0).length)(false))
    for(x<-matrix.indices){
      for(y<-matrix(x).indices){
        canVisit(matrix, x, y, visit,(false,false)) match {
          case (true,true) => buffer += List[Int](x,y)
          case _ => // do nothing
        }
        visit = Array.fill(matrix.length)(Array.fill(matrix(0).length)(false))
      }
    }
    buffer.toList
  }
  def canVisit(matrix:Array[Array[Int]],x:Int,y:Int,visit:Array[Array[Boolean]],curRes:(Boolean,Boolean)):(Boolean,Boolean)={
    visit(x)(y) = true
    var res = curRes
    if(checkLeft(x,y)) res = (true,res._2)
    if(checkRight(x,y,matrix.length-1,matrix(x).length-1)) res = (res._1,true)
    if(res._1 && res._2) return res
    for(i<- pos.indices){
      val newX = x+pos(i)._1
      val newY = y+pos(i)._2
      if(check(newX,newY,matrix.length,matrix(x).length) && !visit(newX)(newY) && matrix(x)(y)>=matrix(newX)(newY) ){
        canVisit(matrix, newX, newY, visit,res) match { // 如果有一边能到达，则更新。
          case (true,true) => res = (true,true)
          case (true,false) => res = (true,res._2)
          case (false,true) => res = (res._1,true)
          case _ => // do nothing
        }
        if(res._1 && res._2) return res
      }
    }
    res
  }

  def checkLeft(x:Int,y:Int):Boolean={
    x<=0 || y<=0
  }
  def checkRight(x:Int,y:Int,xlen:Int,ylen:Int):Boolean={
    x>=xlen || y>=ylen
  }
  def check(x:Int,y:Int,xlen:Int,ylen:Int):Boolean={
    x>=0 && y>=0 && x<xlen && y<ylen
  }
}
//leetcode submit region end(Prohibit modification and deletion)
