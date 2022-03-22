package s801

object Test870 {
  import scala.collection.mutable.ArrayBuffer

  def advantageCount(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    // nums1 逆序排序
    val sortNum1 = nums1.sortWith(_ > _)
    // nums2 逆序排序，并保留元素原有的坐标
    val sortNum2Map = nums2.indices.map(idx => {
      idx -> nums2(idx)
    }).sortWith(_._2 > _._2)
    // 使用sortNum1中最高的和sortNum2Map最高的进行比较。
    // 如果最高的都比其其小，则用最垃圾的来应付。保留实力。

    val res= new Array[Int](nums2.length)
    var left = 0
    var left2 = 0
    var right = sortNum1.length - 1

    // 构建指针，right指向nums1中小的元素
    while (left <= right) {
      // 获取num2中大的元素和坐标。
      val idx = sortNum2Map(left2)._1
      val num = sortNum2Map(left2)._2

      if (sortNum1(left) > num) {
        // 如果sort大的元素比其大，则放入。
        res(idx) = sortNum1(left)
        left += 1
      } else {
        // 如果比其小，则将right的数据放入对应的坐标。right左移
        res(idx) = sortNum1(right)
        right -= 1
      }
      left2 += 1
    }
    res
  }

  def main(args: Array[String]): Unit = {
    val nums1 = Array(12,24,8,32)
    val nums2 = Array(13,25,32,11)
    println(advantageCount(nums1, nums2).mkString(","))
  }
}
