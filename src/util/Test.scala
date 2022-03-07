package util

class Test( val y:Int) {
  val x :Int = y
  def add(that:Test): Int ={
    this.x + that.x
  }
  def binarySearch(nums:Array[Int], target:Int)={
    var left = 0
    var right = 0
    while(...){
      val mid = left + (right - left) / 2
      if(nums(mid) == target){
        // TODO: your code
      }else if(nums(mid) < target){
        // TODO: your code
      }else if(nums(mid) > target){
        // TODO: your code
      }
    }
  }
}
object Test{
  def main(args: Array[String]): Unit = {
    val test = new Test(1)
    val test1 = new Test(2)
    println(test1.add(test1))
  }
}
