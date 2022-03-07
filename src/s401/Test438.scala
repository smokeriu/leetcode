package s401


object Test438 {
  def findAnagrams(s: String, p: String): List[Int] = {
    import scala.collection.mutable
    var res = List[Int]()

    val need = new mutable.HashMap[Char, Int]()
    val window = new mutable.HashMap[Char, Int]()
    p.foreach(c => need += (c -> (need.getOrElse(c, 0) + 1)))

    var left = 0
    var right = 0
    var valid = 0
    while (right < s.length) {
      val c = s(right)
      right += 1

      if (p.contains(c)) {
        window += c -> (window.getOrElse(c, 0) + 1)
        if (window(c) == need(c)) {
          valid += 1
        }
      }

      while (right - left >= p.length) {
        if (valid == need.size) res = left :: res
        val c2 = s(left)
        left += 1
        if (need.contains(c2)) {
          if (window(c2) == need(c2)) {
            valid -= 1
          }
          window(c2) -= 1
        }
      }

    }
    res
  }

  def sum(a :Int, b :Int)={

  }

  def main(args: Array[String]): Unit = {
    findAnagrams("baa","aa")
  }

}
