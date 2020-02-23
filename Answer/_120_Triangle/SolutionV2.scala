package _120_Triangle
import scala.collection.mutable._
object SolutionV2 {
  def minimumTotal(triangle: List[List[Int]]): Int = {
    if(triangle.isEmpty) return 0
    val stat = triangle.last.toBuffer
    for(i<- (0 until triangle.length-1).reverse){
      for(j<-triangle(i).indices){
        stat(j) = triangle(i)(j) + stat(j).min(stat(j+1))
      }
    }
    stat.head
  }
}
