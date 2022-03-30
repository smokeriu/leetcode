package s101

import util.ListNode

object Test160 {
  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    // 如果第一个节点即为相交节点，则直接返回
    if (headA == headB) return headA

    var pa = headA
    var pb = headB

    var aLen = 0
    var bLen = 0

    // 想让pa,pb遍历到底,计算长度。
    while (pa.next != null) {
      pa = pa.next
      aLen += 1
    }

    while (pb.next != null) {
      pb = pb.next
      bLen += 1
    }

    // 得到两个链表的长度差距
    val diff = aLen - bLen
    pa = headA
    pb = headB
    if (diff < 0) {
      // 链表b更长, 是b向后移-diff次
      for (elem <- 0.until(diff, -1)) {
        pb = pb.next
      }
    } else if (diff > 0) {
      // 链表a更长
      for (elem <- 0.until(diff)) {
        pa = pa.next
      }
    } else {
      // 一样长，不做处理
    }

    while (pa != pb && pa != null && pb != null) {
      pa = pa.next
      pb = pb.next
    }
    pa
  }
}
