package _86_Partition_List

object Solution {
  def partition(head: ListNode, x: Int): ListNode = {
    var bigHead : ListNode = new ListNode()
    var smallHead : ListNode = new ListNode()
    var big = bigHead
    var small = smallHead


    var cur = head
    while(cur!=null){
      if(cur.x<x){
        // small
        small.next = cur
        small = small.next
      }else{
        // big
        big.next = cur
        big = big.next
      }
      val next = cur.next
      cur.next = null
      cur = next
    }
    small.next = bigHead.next
    smallHead.next
  }
}
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}
