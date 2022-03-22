package s1

object Test26 {
  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums.length == 0) return 0
    // 用于记录当前的元素坐标，遇到不同的，则将数据更新
    var current = 0
    nums.indices.foreach(idx => {
      if (nums(idx) != nums(current)) {
        nums(current + 1) = nums(idx)
        current += 1
      }
    })
    current + 1
  }
}
