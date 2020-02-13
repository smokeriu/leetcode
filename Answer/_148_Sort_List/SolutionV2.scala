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
object SolutionV2 {
  def sortList(head : ListNode): ListNode ={
    val dummyHead = new ListNode()
    dummyHead.next = head
    var preNode = dummyHead

    var len = 1
    while(preNode != null){
      while (preNode != null){
        // 遍历数组，直到到达尾部
        preNode = sortSubList(preNode, len)
      }
      // 准备二次遍历
      preNode = dummyHead
      len *= 2
      // 遍历一次，如果已经完成排序，则会返回null(len足够长)。否则意味着还需要继续排序。
      // 如要是帮助跳出循环，因为无法知道链表的长度（无法直接确定len的值）。
      preNode = sortSubList(preNode, len)
    }
    dummyHead.next
  }

  def sortSubList(_pre:ListNode,num:Int):ListNode={
    var pre = _pre

    var rightNum = 0
    var leftNum = 0

    var left = pre.next
    var right = left
    // find right's head
    for(i<- 0 until num){
      if (right == null)
        return null
      right = right.next
    }
    // 归并排序
    while (rightNum < num && leftNum < num && right != null){
      if (left.x <= right.x){
        pre.next = left
        left = left.next
        rightNum+=1
      }
      else{
        pre.next = right
        right = right.next
        leftNum+=1
      }
      pre = pre.next
    }
    // left已经sort，right需要接在尾部。
    // 注意避免死循环。
    if (rightNum < num){
      pre.next = left
      while(rightNum<num) {
        rightNum += 1
        pre = pre.next
      }
      pre.next = right
    }else if (leftNum < num && right != null){ // same as left. but need to make sure right is not null
      pre.next = right
      while(leftNum < num && pre!=null){
        pre = pre.next
        leftNum+=1
      }
    }
    // return the tailNode
    pre
  }
}
//leetcode submit region end(Prohibit modification and deletion)
