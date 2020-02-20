package _131_Palindrome_Partitioning

import scala.collection.mutable.ListBuffer
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
// 返回 s 所有可能的分割方案。
//
// 示例:
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//]
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  def partition(s: String): List[List[String]] = {
    if(s == null) return List.empty
    val buffer = ListBuffer[List[String]]()
    func(s,buffer,List[String]())
    buffer.toList
  }
  def func(curStr:String,buffer:ListBuffer[List[String]],res:List[String]):Unit={
    if(curStr.length == 0 ){
      buffer += res
      return
    }
    for(i<-1 to curStr.length){
      val word = curStr.substring(0,i)
      if(check(word)){
        func(curStr.substring(i),buffer,res++List[String](word))
      }
    }


  }
  def check(word:String):Boolean={
    word.reverse == word
  }
}
//leetcode submit region end(Prohibit modification and deletion)

