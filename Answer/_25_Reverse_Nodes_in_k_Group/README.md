使用一个Stack来辅助完成反转。当栈装不满时，说明已经遍历到底了，直接跳出即可。
需要注意的是维护节点的next指针，防止出现死循环。

```scala
  // stack has k eles in it
  while(stack.nonEmpty){
    curNode.next = stack.pop()
    curNode = curNode.next
  }
  curNode.next = head
```
时间复杂度:O(n)// 遍历一遍
空间复杂度:O(k)// 栈空间