package s1


object Test3 {
  def lengthOfLongestSubstring(s: String): Int = {
    import scala.collection.mutable
    val set = new mutable.HashSet[Char]()
    var left = 0
    var right = 0
    var max = 0

    while (right < s.length) {
      val c = s(right)
      right += 1
      // 触发重复
      if (set.contains(c)) {
        // 仅当left到达与c相同时，才会消除重复
        while (s(left) != c) {
          set -= s(left)
          left += 1
        }
        if (left < right) {
          left += 1
        }
      } else {
        set += c
      }
      // 此时是不重复的
      max = math.max(max, right - left)
    }
    max
  }

  def main(args: Array[String]): Unit = {
    val i = lengthOfLongestSubstring("abcabcbb")
    println(i)
  }
}
