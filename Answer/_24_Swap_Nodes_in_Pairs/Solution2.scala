package _24_Swap_Nodes_in_Pairs
/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
// use recursive
object Solution2 {
  def swapPairs(head: ListNode): ListNode = {
    if (head == null || head.next == null){
      return head
    }
    // 让left指向交换后的下一组(left,right)的新left
    val curr = head.next
    head.next = swapPairs(head.next.next)
    curr.next = head

    curr
  }
}
