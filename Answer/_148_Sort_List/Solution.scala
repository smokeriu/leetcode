package _148_Sort_List

//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//
// 示例 1:
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
//
//
// 示例 2:
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
// Related Topics 排序 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
// 归并
object Solution {
  def sortList(head: ListNode): ListNode = {
    if(head== null || head.next == null) return head

    var slow = head
    var fast = slow.next
    while(fast.next!=null && fast.next.next != null){
      slow = slow.next
      fast = fast.next.next
    }
    // split to two listNode
    val tmp = slow.next
    slow.next = null

    var left = sortList(head)
    var right = sortList(tmp)
    val dummyHead = new ListNode()
    var res = dummyHead
    // compare two listNode
    while(left!=null && right!=null){
      if(left.x < right.x){
        res.next = left
        left = left.next
        res = res.next
      }else{
        res.next = right
        res = right
        right = right.next
      }
    }
    res.next = if(left==null) right else left
    dummyHead.next
  }
}
//leetcode submit region end(Prohibit modification and deletion)
