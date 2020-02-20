package _17_Letter_Combinations_of_a_Phone_Number

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 字符串 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object SolutionV1 {
  def letterCombinations(digits: String): List[String] = {
    var buffer = ListBuffer[String]()
    for(i<-digits){
      val strs = i match {
        case '2' => "abc"
        case '3' => "def"
        case '4' => "ghi"
        case '5' => "jkl"
        case '6' => "mno"
        case '7' => "pqrs"
        case '8' => "tuv"
        case '9' => "wxyz"
        case '0' => " "
      }
      if(buffer.isEmpty){
        strs.foreach(x=> buffer += x.toString)
      }else{
        val tmp = ListBuffer[String]()
        for(x<-strs ;y<-buffer){
          tmp += y + x.toString
        }
        buffer = tmp
      }
    }
    buffer.toList
  }
}
//leetcode submit region end(Prohibit modification and deletion)

