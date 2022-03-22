package s1

import util.ListNode

object Test83 {
  def deleteDuplicates(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    var current = head.x
    var next = head.next
    var cur = head
    while (next != null) {
      if (next.x == current) {
        // 重复元素,需要将链表重新连接
        // 当前指针指向next的下一项，将next从链表中删去
        cur.next = next.next
        // 将next重新指向下一项
        next = cur.next
      } else {
        // 非重复元素
        // 记录当前的current数据
        current = next.x
        // 将cur指向下一个
        cur = next
        // 将next指向下一个
        next = next.next
      }
    }

    head
  }
}
