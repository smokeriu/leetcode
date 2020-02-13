package _21_Merge_Two_Sorted_Lists
//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
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
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    val dummyHead = new ListNode()
    var curNode = dummyHead
    var head1 = l1
    var head2 = l2
    while(head1!=null && head2 !=null){
      if(head1.x <= head2.x){
        curNode.next = head1
        head1 = head1.next
        curNode = curNode.next
      }else{
        curNode.next = head2
        head2 = head2.next
        curNode = curNode.next
      }
    }
    if(head1 != null){
      curNode.next = head1
    }else if(head2!= null){
      curNode.next = head2
    }
    dummyHead.next
  }
}
//leetcode submit region end(Prohibit modification and deletion)

