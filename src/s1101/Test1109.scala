package s1101

/**
 * 使用差分数组
 */
object Test1109 {
  def corpFlightBookings(bookings: Array[Array[Int]], n: Int): Array[Int] = {
    val ans = Array.fill(n)(0)

    for (book <- bookings) {
      ans(book(0) - 1) += book(2)
      if (book(1) < n)
        ans(book(1)) -= book(2)
    }

    for (i <- 1 until n) {
      ans(i) += ans(i - 1)
    }
    ans
  }
}
