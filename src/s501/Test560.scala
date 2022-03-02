package s501

/**
 * 使用数组前缀和
 */
object Test560 {
  def subarraySum(nums: Array[Int], k: Int): Int = {
    var sum = 0
    var count = 0
    val buffer = scala.collection.mutable.HashMap[Int, Int]()
    buffer += 0 -> 1

    for (elem <- nums.indices) {
      sum += nums(elem)
      count += buffer.getOrElse(sum - k, 0)
      buffer += sum -> (buffer.getOrElse(sum, 0) + 1)
    }
    count
  }
}