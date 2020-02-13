这题需要注意就一个点。因为第一个节点也可能被删除，所以需要使用一个虚拟头节点。
```scala
  val dummyNode = new ListNode()
  dummyNode.next = cur
```
另外注意维护下当最后一个节点=val时，pre指针需要指向null
```scala
  if (cur.x == `val`) {
    cur = cur.next
    pre.next = cur
  }
```
空间复杂度O(1)
时间复杂度O(n)