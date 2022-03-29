package s1

import util.ListNode

object Test19 {
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    var p = head
    // 将p向后移n位
    for (i <- 0 until n) {
      p = p.next
    }

    // 将p移动到尾部，此时p2代表的就是倒数第n个节点
    var p2 = head
    while (p.next != null) {
      p2 = p2.next
      p = p.next
    }

    val next = p2.next
    p2.next = next.next

    head
  }
}
