package _93_Restore_IP_Addresses

//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//
// 示例:
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"]
// Related Topics 字符串 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
import scala.collection.mutable._
object Solution {
  def restoreIpAddresses(s: String): List[String] = {
    if(s == null) return List.empty
    val buffer = ListBuffer[String]()
    val tmp = List[String]()
    func(s,buffer,tmp)
    buffer.toList
  }
  def func(curStr:String,buffer:ListBuffer[String],res:List[String]):Unit={
    if(curStr.length/3+res.length > 4) return // 不能组成ip
    if(curStr.length == 0 && res.length == 4) {
      buffer += res.mkString(".")
      return
    }
    //1
    if(curStr.length>=1){
      val x = curStr.substring(0,1)
      func(curStr.substring(1),buffer,res.:+(x))
    }
    //2
    if(curStr.length >= 2 && !curStr.startsWith("0")){
      val y = curStr.substring(0,2)
      func(curStr.substring(2),buffer,res.:+(y))

    }
    //3
    if(curStr.length >= 3  && !curStr.startsWith("0") ){
      val z = curStr.substring(0,3).toInt
      if(z > 255)  return
      func(curStr.substring(3),buffer,res.:+(z.toString))
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)

