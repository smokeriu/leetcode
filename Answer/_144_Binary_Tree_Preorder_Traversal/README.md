通过递归遍历。

空间复杂度O(n) 
时间复杂度O(n) 

---
也可以使用栈而不是递归。
V2就是简单的入栈出栈，这种办法在实现中序遍历和后续遍历时会麻烦些。
---
V3则是模拟系统的出入栈，不过这种方法在leetcode会超出内存限制，猜测可能是压栈对象导致的。理论上这种方法时ok的。
而且这种方法作用到中序遍历和后序遍历会非常简单。