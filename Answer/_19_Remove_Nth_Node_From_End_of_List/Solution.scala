package _19_Remove_Nth_Node_From_End_of_List

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//
// 说明：
//
// 给定的 n 保证是有效的。
//
// 进阶：
//
// 你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    val dummyHead = new ListNode()
    dummyHead.next = head
    var left = dummyHead
    var right = dummyHead
    for(i<- 1 to n){
      right = right.next
    }
    // left -> +n.. -> right
    while(right.next!=null){
      left = left.next
      right = right.next
    }
    left.next = left.next.next
    dummyHead.next
  }
}
//leetcode submit region end(Prohibit modification and deletion)

