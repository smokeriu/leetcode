用中序遍历做，把数组遍历出来即可。最坏时间复杂度是O(n)

还有一种是找左侧的count，然后判断元素在左边还是右边。
这种虽然更难想，但算了下实际时间复杂度反而更高。

PS：我是不知道为啥这题标注了二分搜索法。。




空间复杂度O(n) // 最坏情况需要从根遍历到叶子节点，遍历一次。
时间复杂度O(H) // 树的高度 