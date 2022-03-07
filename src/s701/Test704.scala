package s701

object Test704 {
  def search(nums: Array[Int], target: Int): Int = {
    var left = 0
    var right = nums.length - 1

    while (left <= right) {
      val mid = left + (right - left) / 2
      if (nums(mid) == target) {
        return mid
      } else if (nums(mid) > target) {
        // 窗口左移
        right = mid - 1
      } else if (nums(mid) < target) {
        // 窗口右移
        left = mid + 1
      }
    }
    nums.indexOf()
    -1
  }
}
