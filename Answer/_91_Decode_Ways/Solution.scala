package _91_Decode_Ways

//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
// 示例 1:
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
//
//
// 示例 2:
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  def numDecodings(s: String): Int = {
    // 必须使用记忆集，不然测试内存会不足。
    val buffer = HashMap[String,Int]()
    func(s,buffer)
  }
  def func(s:String,buffer:HashMap[String,Int]):Int={
    if(s.length==1 && s.toInt >0) return 1
    var count = 0
    if(s.length==2 && !s.startsWith("0") && s.toInt <= 26 && s.toInt >0) count += 1
    for(i<-1 until s.length){
      val tmp = s.substring(0,i)
      //println(s"tmp:$tmp")
      if(tmp.length<=2 && !tmp.startsWith("0") && tmp.toInt<=26 && tmp.toInt >0){
        if(buffer.contains(s.substring(i,s.length))){
          count += buffer(s.substring(i,s.length))
        }else{
          val res = func(s.substring(i,s.length),buffer)
          count += res
          buffer.put(s.substring(i,s.length),res)
        }

      }
    }
    count
  }
}
//leetcode submit region end(Prohibit modification and deletion)
