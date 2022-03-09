package s801

class Test875 {
  def minEatingSpeed(piles: Array[Int], h: Int): Int = {
    var left = 1
    var right = piles.max
    while (left <= right) {
      val mid = left + (right - left) / 2
      if (canEat(piles, mid, h)) {
        // 说明k足够，但可能存在更小值
        right = mid - 1
      } else {
        // 说明k太小
        left = mid + 1
      }
    }
    left
  }

  private def canEat(piles: Array[Int], k: Int, h: Int): Boolean = {

    piles.map(elem => (elem + k - 1) / k).sum <= h
  }
}
