package _143_Reorder_List

//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
// 示例 1:
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
//
// 示例 2:
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
import scala.collection.mutable._
object Solution {
  def reorderList(head: ListNode): Unit = {
    if(head==null || head.next == null) return
    var slow = head
    var fast = head.next
    // find the mid in ListNode
    while(fast.next !=null && fast.next.next !=null){
      slow = slow.next
      fast = fast.next.next
    }
    var secondNode = slow.next
    val tmpNode = slow.next
    slow.next = null
    slow = head
    val dummyHead = new ListNode()
    var curNode = dummyHead
    // reverse second ListNode,use stack make it easier.
    val stack = Stack[ListNode]()
    while(secondNode!=null){
      stack.push(secondNode)
      secondNode = secondNode.next
    }
    while(stack.nonEmpty){
      // fisrt Node may less than second
      if(slow!=null){
        curNode.next = slow
        curNode = curNode.next
        slow=slow.next
      }
      val next =stack.pop()
      curNode.next = next
      next.next = null
      curNode = curNode.next
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)
