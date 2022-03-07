package s1

object Test34 {
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    var left = 0
    var right = nums.length - 1
    var findL = -1
    var findR = -1
    while (left <= right) {
      val mid = left + (right - left) / 2
      if (nums(mid) == target) {
        // 这个元素可能位于中央，故拆分成两个子数组。
        val left1 = left
        val right1 = mid

        val left2 = mid
        val right2 = right

        findL = searchLeft(nums, left1, right1, target)
        findR = searchRight(nums, left2, right2, target)

        left = right + 1

      } else if (nums(mid) > target) {
        right = mid - 1
      } else if (nums(mid) < target) {
        left = mid + 1
      }
    }

    Array[Int](findL, findR)
  }

  def searchLeft(nums: Array[Int], _left: Int, _right: Int, target: Int): Int = {
    var left = _left
    var right = _right
    while (left <= right) {
      println("search in left")
      val mid = left + (right - left) / 2
      if (nums(mid) == target) {
        right = mid - 1
      } else if (nums(mid) > target) {
        right = mid - 1
      } else if (nums(mid) < target) {
        left = mid + 1
      }
    }

    left
  }

  def searchRight(nums: Array[Int], _left: Int, _right: Int, target: Int): Int = {
    var left = _left
    var right = _right
    while (left <= right) {
      println("search in right")
      val mid = left + (right - left) / 2
      if (nums(mid) == target) {
        left = mid + 1
      } else if (nums(mid) > target) {
        right = mid - 1
      } else if (nums(mid) < target) {
        left = mid + 1
      }
    }

    right
  }

  def main(args: Array[String]): Unit = {
    val nums = Array[Int](5, 7, 7, 8, 8, 10)
    val target = 8
    searchRange(nums, target)
  }
}
