package _82_Remove_Duplicates_from_Sorted_List_II

//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
// 示例 1:
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
//
//
// 示例 2:
//
// 输入: 1->1->1->2->3
//输出: 2->3
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
  def deleteDuplicates(head: ListNode): ListNode = {
    var dummy = new ListNode()
    var cur = head
    dummy.next = head
    var pre = dummy
    while(cur != null && cur.next != null){
      if(cur.x == cur.next.x) {
        while (cur.next != null && cur.x == cur.next.x) {
          cur = cur.next;
        }
        pre.next = cur.next
        cur = cur.next
      }else{
        pre = cur
        cur = cur.next
      }
    }
    dummy.next
  }
}
//leetcode submit region end(Prohibit modification and deletion)