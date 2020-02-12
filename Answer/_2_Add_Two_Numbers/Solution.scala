package _2_Add_Two_Numbers

import _445_Add_Two_Numbers_II.ListNode

object Solution {
  def addTwoNumbers( _l1: ListNode, _l2: ListNode): ListNode = {
    var l1 = _l1
    var l2 = _l2
    val resHead = new  ListNode()
    var curNode = resHead
    var res = 0
    while(l1!=null && l2!=null){
      res += l1.x + l2.x
      val cur = res % 10
      curNode.next = new ListNode(cur)
      curNode = curNode.next
      res /= 10
      l1 = l1.next
      l2 = l2.next
    }
    while(l1!=null){
      res = res + l1.x
      val cur = res % 10
      curNode.next = new ListNode(cur)
      curNode = curNode.next
      res /= 10
      l1 = l1.next
    }
    while(l2!=null){
      res = res + l2.x
      val cur = res % 10
      curNode.next = new ListNode(cur)
      curNode = curNode.next
      res /= 10
      l2 = l2.next
    }
    if(res > 0){
      curNode.next = new ListNode(res)
    }
    resHead.next
  }
}
