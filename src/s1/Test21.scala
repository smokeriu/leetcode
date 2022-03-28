package s1

import util.ListNode

object Test21 {
  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    val dummy = new ListNode(-1)
    var p = dummy

    var p1 = list1
    var p2 = list2

    while (p1 != null && p2 != null) {
      if (p1.x > p2.x) {
        // p1 > p2.
        p.next = p2
        p2 = p2.next
      } else {
        p.next = p1
        p1 = p1.next
      }
      p = p.next
    }

    if (p1 != null) {
      p.next = p1
    }

    if (p2 != null) {
      p.next = p2
    }

    dummy.next
  }
}
