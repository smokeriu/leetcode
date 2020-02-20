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
object SolutionV2 {
  def letterCombinations(digits: String): List[String] = {
    if(digits == null) return List.empty
    val buffer = ArrayBuffer[String]()
    func("",digits,buffer)
    buffer.toList
  }

  def func(res:String,next_digits:String,buffer:ArrayBuffer[String]):Unit={
    if(next_digits.length == 0){
      buffer += res
    }else{
      val strs = next_digits.substring(0, 1) match {
        case "2" => "abc"
        case "3" => "def"
        case "4" => "ghi"
        case "5" => "jkl"
        case "6" => "mno"
        case "7" => "pqrs"
        case "8" => "tuv"
        case "9" => "wxyz"
        case "0" => " "
      }
      for(x<-strs){
        func(res + x,next_digits.substring(1),buffer)
      }
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)

