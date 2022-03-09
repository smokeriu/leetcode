package s1001

object Test1011 {
  def shipWithinDays(weights: Array[Int], days: Int): Int = {
    var left = weights.max
    var right = weights.sum
    while (left <= right) {
      val mid = left + (right - left) / 2
      if (canShip(weights, days, mid)) {
        right = mid - 1
      } else {
        left = mid + 1
      }
    }
    left
  }

  def canShip(weights: Array[Int], days: Int, boat: Int): Boolean = {
    var sum = 0
    var day = 0
    for (w <- weights) {
      if (sum > boat - w) {
        day += 1
        sum = w
      } else {
        sum += w
      }
    }
    day < days
  }
}
