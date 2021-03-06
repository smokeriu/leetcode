package _61_Rotate_List

import _148_Sort_List.ListNode
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
//
//
// 示例 2:
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL
// Related Topics 链表 双指针


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object SolutionV2 {
  def rotateRight(head: ListNode, k: Int): ListNode = {
    if(head==null || head.next==null||k==0) return head
    val dummyHead = new ListNode()
    var curNode = head
    var size = 1
    while(curNode.next!=null){
      curNode = curNode.next
      size +=1
    }
    curNode.next = head
    curNode = head
    var pos = size - k % size
    while(pos>1){
      curNode = curNode.next
      pos-=1
    }
    dummyHead.next =curNode.next
    curNode.next = null
    dummyHead.next
  }
}
//leetcode submit region end(Prohibit modification and deletion)
