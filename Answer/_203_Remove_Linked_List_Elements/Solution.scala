package _203_Remove_Linked_List_Elements

/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def removeElements(head: ListNode, `val`: Int): ListNode = {
    val dummyNode = new ListNode()
    var cur = head
    dummyNode.next = cur
    var pre = dummyNode
    while (cur != null) {
      if (cur.x == `val`) {
        cur = cur.next
        pre.next = cur
      } else {
        pre=cur
        cur=cur.next
      }
    }

    dummyNode.next
  }
}
