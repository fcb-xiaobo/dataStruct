数组介绍


1）什么是数组

数组（Array）是一种线性表数据结构。
它用一组连续的内存空间，来存储一组具有相同类型



线性结构

线性表就是数据排成像一条线一样的结构。每个线性表上的数据最多只有前和后两个方向。
其实除了数组，链表.队列、栈等也是线性表结构。而与它相对立的概念是非线性表，
比如二叉树、堆、图等。之所以叫非线性，是因为，在非线性表中，数据之间并不是简单的前后关系。



续的内存空间和相同类型的数据
。
正是因为这两个限制，它才有了一个堪称“杀
手锏”
的特性：
“随机访问”
。
但有利就有弊，这两个限制也让数组的很多操作变得非常低
效，比如要想在数组中删除、
插入一个数据，为了保证连续性，就需要做大量的数据搬移工
作。




如何实现随机访问...

我们拿一个长度为 10 的 int 类型的数组 int[] a = new int[10] 来举例。
在我画的这个图
中，计算机给数组 a[10]，分配了一块连续内存空间 1000～1039，其中，内存块的首地址
为 base_address = 1000。
、我们知道，计算机会给每个内存单元分配一个地址，计算机通过地址来访问内存中的数据。
 当计算机需要随机访问数组中的某个元素时，它会首先通过下面的寻址公式，计算出该元素
 存储的内存地址：
 
 a[i]_address = base_address + i * data_type_size


其中 data_type_size 表示数组中每个元素的大小。
我们举的这个例子里，数组中存储的是
i
nt 类型数据，所以 data_type_size 就为 4 个字节。
这个公式非常简单.



数组的下标记为何从0开始


