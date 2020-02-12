package _445_Add_Two_Numbers_II

//给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
//
//
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//
// 进阶:
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
//
// 示例:
//
//
//输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出: 7 -> 8 -> 0 -> 7
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
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val stack1 = Stack[ListNode]()
    val stack2 = Stack[ListNode]()
    // 使用栈来反转ListNode.
    var head1 = l1
    var head2 = l2
    while(head1!=null){
      stack1.push(head1)
      head1 = head1.next
    }
    while(head2!=null){
      stack2.push(head2)
      head2 = head2.next
    }

    var dummyHead :ListNode = null
    var addBatch = 0
    while(stack1.nonEmpty || stack2.nonEmpty){
      var res = 0
      if(stack1.nonEmpty){
        res += stack1.pop().x
      }
      if(stack2.nonEmpty){
        res += stack2.pop().x
      }
      res += addBatch
      addBatch = res / 10
      res = res % 10
      val cur = new ListNode(res)
      cur.next = dummyHead
      dummyHead = cur
    }
    if(addBatch!=0){
      val cur = new ListNode(addBatch)
      cur.next = dummyHead
      dummyHead = cur
    }
    dummyHead


  }
}
//leetcode submit region end(Prohibit modification and deletion)
