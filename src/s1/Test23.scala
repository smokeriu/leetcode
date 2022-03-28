package s1

import util.ListNode

object Test23 {

  import scala.collection.mutable

  def mergeKLists(lists: Array[ListNode]): ListNode = {


    val priorityQueue = new mutable.PriorityQueue[ListNode]()(Ordering.by(-_.x))
    lists.foreach(node => {
      if (node != null) {
        priorityQueue.+=(node)
      }
    })

    var dummy = new ListNode(-1, null)
    val head = dummy

    while (priorityQueue.nonEmpty) {
      val node = priorityQueue.dequeue()
      dummy.next = node
      dummy = dummy.next
      if (node.next != null) {
        priorityQueue.+=(node.next)
      }
    }
    head.next
  }
}
