package _130_Surrounded_Regions
//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//
// 示例:
//
// X X X X
//X O O X
//X X O X
//X O X X
//
//
// 运行你的函数后，矩阵变为：
//
// X X X X
//X X X X
//X X X X
//X O X X
//
//
// 解释:
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
// 先遍历边界，找到不变的。
// 再遍历中间，找到需要变得。
import scala.collection.mutable._
object Solution {
  val pos = Array[(Int,Int)]((-1,0),(1,0),(0,-1),(0,1))
  def solve(board: Array[Array[Char]]): Unit = {
    if(board==null || board.length==0) return
    // 遍历边界。
    val visit = Array.fill(board.length)(Array.fill(board(0).length)(false))
    for(i<-board.indices){
      search(board,i,0,visit)
      search(board,i,board(i).length-1,visit)
    }
    for(j<-board(0).indices){
      search(board,0,j,visit)
      search(board,board.length-1,j,visit)
    }
    //复原
    for(x<-board.indices){
      for(y<-board(x).indices){
        if(board(x)(y)=='Z'){
          board(x)(y)='O'
        }else if(board(x)(y)=='O'){
          board(x)(y) = 'X'
        }
      }
    }
  }
  def search(board:Array[Array[Char]],x:Int,y:Int,visit:Array[Array[Boolean]]):Unit={
    if(board(x)(y)=='Z'||board(x)(y)=='X') return
    if(board(x)(y)=='O'){

      board(x)(y) = 'Z'
      visit(x)(y) = true
      for(i<- 0 to 3){
        val newx = x+pos(i)._1
        val newy = y+pos(i)._2
        if(check(newx,newy,board.length,board(0).length) && !visit(newx)(newy)){
          search(board,newx,newy,visit)
        }
      }
    }
  }
  def check(x:Int,y:Int,xLen:Int,yLen:Int)={
    x>=0 && y>=0 && x<xLen && y<yLen
  }

}
//leetcode submit region end(Prohibit modification and deletion)

