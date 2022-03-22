package s1

object Test27 {
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    var left = 0
    var right = nums.length - 1
    while (left <= right) {
      if (nums(left) == `val`) {
        nums(left) = nums(right)
        right -= 1
      } else {
        left += 1
      }
    }
    left
  }

  def removeElement2(nums: Array[Int], `val`: Int): Int = {
    var slow = 0
    var fast = 0
    while (fast < nums.length) {
      if (nums(fast) != `val`) {
        nums(slow) = nums(fast)
        slow += 1
      }
      fast += 1
    }
    slow
  }
}
