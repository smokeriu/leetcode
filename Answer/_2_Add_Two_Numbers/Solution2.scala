package _2_Add_Two_Numbers

object Solution2 {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    def add(l1: ListNode, l2: ListNode, addBit: Int, prev: ListNode): Unit = {
      (l1, l2) match {
        case (null, null) =>
          if(addBit != 0) {
            prev.next = new ListNode(addBit)
          }
        case (l1, null) =>
          val sum = l1.x + addBit
          prev.next = new ListNode(sum % 10)
          add(l1.next, null, sum / 10, prev.next)
        case (null, l2) =>
          val sum = l2.x + addBit
          prev.next = new ListNode(sum % 10)
          add(null, l2.next, sum / 10, prev.next)
        case (l1, l2) =>
          val sum = l2.x + l1.x + addBit
          prev.next = new ListNode(sum % 10)
          add(l1.next, l2.next, sum / 10, prev.next)
      }
    }
    val dummyHead = new ListNode(0)
    add(l1, l2, 0, dummyHead)
    dummyHead.next
  }
}

