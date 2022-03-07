package s1

object Test76 {
  def minWindow(s: String, t: String): String = {
    val need = new scala.collection.mutable.HashMap[Char, Int]
    val window = new scala.collection.mutable.HashMap[Char, Int]
    t.foreach(c => need(c) = need.getOrElse(c, 0) + 1)
    var left = 0
    var right = 0
    var valid = 0
    var start = 0
    var end = Int.MaxValue
    while (right < s.length) {
      val c = s(right)

      // 右移窗口
      right += 1

      if (need.contains(c)) {
        window(c) = window.getOrElse(c, 0) + 1
        if (window(c) == need(c)) {
          // 合格数+1
          valid += 1
        }
      }

      // 符合条件
      while (valid == need.size) {
        // 更新结果
        if (right - left < end - start) {
          start = left
          end = right
        }
        val leftC = s(left)
        // 左移窗口
        left += 1
        if (need.contains(leftC)) {
          window(leftC) -= 1
          if (window(leftC) < need(leftC)) {
            valid -= 1
          }
        }
      }
    }
    if (end > s.length)
      ""
    else
      s.slice(start, end)
  }

}
