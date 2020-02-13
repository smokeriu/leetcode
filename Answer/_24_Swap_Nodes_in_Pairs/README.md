1、建立一个虚拟头节点，并于head相连。
2、swap(left,right)，即让right指向left，left指向right.next。注意顺序。
3、让dummyHead(preNode)指向right。
4、更新preNode的位置到原来的left。

空间复杂度O(1)
时间复杂度O(n)

ps：此题也可以使用递归来做。