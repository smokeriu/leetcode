package s1001

object Test1094 {
  def carPooling(trips: Array[Array[Int]], capacity: Int): Boolean = {
    val map = new scala.collection.mutable.HashMap[Int, Int]()

    for (trip <- trips) {
      map += (trip(1) -> (map.getOrElse(trip(1), 0) + trip(0)))
      map += (trip(2) -> (map.getOrElse(trip(2), 0) - trip(0)))
    }

    var sum = 0
    map.toSeq.sortBy(_._1)
      .foreach(kv => {
        sum += kv._2
        if (sum > capacity) return false
      })

    true

  }
}
