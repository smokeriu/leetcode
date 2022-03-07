package util

class MidSearch {
  def searchLeft(a: Array[Int], x: Int): Int = {
    var left = 0
    var right = a.length - 1
    while (left <= right) {
      val mid = left + (right - left) / 2
      if (a(mid) == x) {
        right = mid
      } else if (a(mid) < x) {
        left = mid + 1
      } else if (a(mid) > x) {
        right = mid - 1
      }
    }
    if (left >= a.length || a(left) != x) {
      -1
    } else {
      left
    }
  }
}
