递归比较简单。

用遍历主要是注意遍历顺序，观察后序遍历规则，约上层的根元素越完输出，所以我们遍历时就可以直接将根元素添加到res链表尾部，然后先遍历右侧。

空间复杂度O(n) 
时间复杂度O(n) 
