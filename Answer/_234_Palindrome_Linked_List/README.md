想要在O(1)的空间解决，意味着后半链表需要原地反转。这部分==参考206题。

先通过快慢指针，找到中间节点，然后将后半部分节点反转即可。

反转完成后依次比较。值得注意的是当链表节点为奇数个时，要特殊处理下。这个可以通过fast指针最后的位置判断。

空间复杂度O(1)
时间复杂度O(n)