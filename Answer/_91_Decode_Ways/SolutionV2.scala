package _91_Decode_Ways

import scala.collection.mutable._
object SolutionV2 {
  def numDecodings(s: String): Int = {
    if(s(0)==0) return 0
    var count = 1
    var cur = 1
    var pre = 1
    for(i<-1 until s.length){
      //println(s(i).toString.toInt)
      val tmp = cur
      if(s(i)=='0'){
        if(s(i-1) == '2' || s(i-1) == '2') cur = pre
        else return 0
      }else if(s(i-1) == '1'){
        cur += pre
      }else if(s(i-1) == '2' && s(i)<='6'){
        cur += pre
      }
      pre = tmp
    }
    cur
  }
}
