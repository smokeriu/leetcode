package _25_Reverse_Nodes_in_k_Group


//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
// 示例 :
//
// 给定这个链表：1->2->3->4->5
//
// 当 k = 2 时，应当返回: 2->1->4->3->5
//
// 当 k = 3 时，应当返回: 3->2->1->4->5
//
// 说明 :
//
//
// 你的算法只能使用常数的额外空间。
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
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
import scala.collection.mutable._
object Solution {
  def reverseKGroup( _head: ListNode, k: Int): ListNode = {
    val dummyHead = new ListNode()
    dummyHead.next = _head
    var head = _head
    var curNode = dummyHead
    val stack = Stack[ListNode]()
    while(head!=null){
      var num = k
      stack.clear()
      while(num>0 ){
        stack.push(head)
        num -=1
        head = head.next
        if(head == null && num>0) return dummyHead.next
      }
      // stack has k eles in it
      while(stack.nonEmpty){
        curNode.next = stack.pop()
        curNode = curNode.next
      }
      curNode.next = head
    }
    dummyHead.next
  }
}
//leetcode submit region end(Prohibit modification and deletion)

