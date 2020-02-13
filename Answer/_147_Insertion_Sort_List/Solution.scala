package _147_Insertion_Sort_List

//对链表进行插入排序。
//
//
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
//
//
//
// 插入排序算法：
//
//
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
// 重复直到所有输入数据插入完为止。
//
//
//
//
// 示例 1：
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
//
//
// 示例 2：
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
//
// Related Topics 排序 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def insertionSortList(head: ListNode): ListNode = {
    if(head == null || head.next==null) return head
    val dummyHead = new ListNode()
    dummyHead.next = head
    var preNode = head
    var curNode = head.next
    while(curNode!=null){
      // need sort
      if(curNode.x < preNode.x){
        preNode.next = curNode.next
        val value = curNode.x
        var tmpNode = dummyHead
        while(tmpNode.next.x < value){
          tmpNode = tmpNode.next
        }
        // find pos to insert
        curNode.next = tmpNode.next
        tmpNode.next = curNode

        curNode = preNode.next
      }else{
        preNode = curNode
        curNode = curNode.next
      }
    }
    dummyHead.next

  }
}
//leetcode submit region end(Prohibit modification and deletion)
