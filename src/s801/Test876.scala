package s801

import util.ListNode

object Test876 {
  def middleNode(head: ListNode): ListNode = {
    // 快指针一次走两步，慢指针一次走一步
    var slow = head
    var fast = head
    while (fast.next != null && fast.next.next != null) {
      // fast的后两位都不是null，则其可以向后移动
      slow = slow.next
      fast = fast.next.next
    }

    if (fast.next == null){
      // 如果后一位为null，说明是奇数
      slow
    }else{
      // 否则是偶数
      slow.next
    }

  }
}
