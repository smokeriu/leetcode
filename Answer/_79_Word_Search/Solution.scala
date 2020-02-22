package _79_Word_Search

//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
// 示例:
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true.
//给定 word = "SEE", 返回 true.
//给定 word = "ABCB", 返回 false.
// Related Topics 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)

object Solution {
  val pos = Array[(Int,Int)]((-1,0),(1,0),(0,-1),(0,1))
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    if(board == null) return false
    val used = Array.fill(board.length)(Array.fill(board(0).length)(false))
    for(i<-board.indices){
      for(j<-board(i).indices){
        if(serach(board,word,i,j,used)){
          return true
        }
      }
    }
    false
  }
  def serach(board:Array[Array[Char]],word:String,x:Int,y:Int,used:Array[Array[Boolean]]):Boolean={
    if(board(x)(y)!=word(0)) return false
    if(board(x)(y)==word(0) && word.length == 1) return true
    if(board(x)(y)==word(0)){
      used(x)(y) = true
      for(i<-0 to 3){
        val newx = x+pos(i)._1
        val newy = y+pos(i)._2
        if(check(newx,newy,board.length,board(0).length) && !used(newx)(newy)){
          if(serach(board,word.substring(1),newx,newy,used)) return true
        }
      }
      used(x)(y) = false
    }
    false

  }
  def check(x:Int,y:Int,xlen:Int,ylen:Int):Boolean={
    x>=0 && x<xlen && y>=0 && y<ylen
  }
}
//leetcode submit region end(Prohibit modification and deletion)

