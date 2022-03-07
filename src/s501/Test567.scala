package s501

object Test567 {
  def checkInclusion(s1: String, s2: String): Boolean = {
    val need = new scala.collection.mutable.HashMap[Char, Int]()
    val window = new scala.collection.mutable.HashMap[Char, Int]()
    s1.foreach(c => {
      need.put(c, need.getOrElse(c, 0) + 1)
    })
    var left = 0
    var right = 0
    var valid = 0
    while (right < s2.length) {
      val c = s2(right)
      right += 1
      // 如果这个字符符合条件，则加入window
      if (need.contains(c)) {
        window += c -> (window.getOrElse(c, 0) + 1)
        if (window(c) == need(c)) {
          valid += 1

        }
      } else {
        // 如果不符合，则清空window
        window.clear()
        valid = 0
        left = right
      }


      // 如果窗口较长，说明有重复字符
      while (right - left >= s1.length) {
        if (valid == need.size) return true
        val c2 = s2(left)
        left += 1
        if (need.contains(c2)) {
          if (window(c2) == need(c2)) {
            valid -= 1
          }
          window(c2) -= 1
        }
      }

    }
    false
  }
}
