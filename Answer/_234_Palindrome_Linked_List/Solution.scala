package _234_Palindrome_Linked_List

import _148_Sort_List.ListNode
//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
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
  def isPalindrome(head: ListNode): Boolean = {
    if(head == null || head.next == null) return true
    var slow = head
    var fast = head.next
    while(fast.next != null && fast.next.next!=null){
      slow = slow.next
      fast = fast.next.next
    }
    var secondHead = slow.next
    slow.next = null
    val dummyHead = if(fast.next == null){
      // 偶数
      fast
    }else{
      // 奇数
      secondHead = secondHead.next
      fast.next
    }
    reverse(secondHead)
    var left = head
    var right = dummyHead
    while(left!=null && right!=null){
      if(left.x != right.x){
        return false
      }
      left = left.next
      right = right.next
    }
    true
  }

  def reverse(head:ListNode)={
    var preNode = new ListNode()
    var curNode = head
    var nextNode = head.next
    while(nextNode!=null){
      curNode.next = preNode
      val next = nextNode.next
      nextNode.next = curNode
      preNode = curNode
      curNode = nextNode
      nextNode = next
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)
