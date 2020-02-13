package _24_Swap_Nodes_in_Pairs

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例:
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
//
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def swapPairs(head: ListNode): ListNode = {
    if(head == null || head.next == null) return head
    val dummyHead = new ListNode()
    var curNode = dummyHead
    // connect dummyHead and head . dummyHead -> head
    dummyHead.next = head

    while(curNode.next!=null && curNode.next.next!=null){
      val left = curNode.next
      val right = curNode.next.next

      // move
      left.next = right.next
      right.next = left
      curNode.next = right

      // refresh curNode
      curNode = left
    }
    dummyHead.next
  }
}
//leetcode submit region end(Prohibit modification and deletion)
