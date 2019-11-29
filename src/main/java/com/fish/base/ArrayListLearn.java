package com.fish.base;

public class ArrayListLearn {

    public static void main(String[] args) {
        try {
            String[] a = new String[Integer.MAX_VALUE - 1];
            System.out.println(a.length);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void learn() {

        /**
         * ArrayList 的底层是数组队列，相当于动态数组。
         * 与 Java 中的数组相比，它的容量能动态增长。
         * 在添加大量元素前，应用程序可以使用ensureCapacity操作来增加 ArrayList 实例的容量。这可以减少递增式再分配的数量。
         * 在我们学数据结构的时候就知道了线性表的顺序存储，插入删除元素的时间复杂度为O（n）,求表长以及增加元素，取第 i 元素的时间复杂度为O（1）
         *
         * 它继承于 AbstractList，实现了 List, RandomAccess, Cloneable, java.io.Serializable 这些接口。
         * 1. ArrayList 继承了AbstractList，实现了List。它是一个数组队列，提供了相关的添加、删除、修改、遍历等功能。
         * 2. ArrayList 实现了RandomAccess 接口， RandomAccess 是一个标志接口，表明实现这个这个接口的 List 集合是支持快速随机访问的。
         *      在 ArrayList 中，我们即可以通过元素的序号快速获取元素对象，这就是快速随机访问。
         * 3. ArrayList 实现了Cloneable 接口，即覆盖了函数 clone()，能被克隆。
         * 4. ArrayList 实现java.io.Serializable 接口，这意味着ArrayList支持序列化，能通过序列化去传输。
         * 5. 和 Vector 不同，ArrayList 中的操作不是线程安全的！所以，建议在单线程中才使用 ArrayList，而在多线程中可以选择 Vector 或者 CopyOnWriteArrayList。
         *
         * 此无参构造函数将创建一个 DEFAULTCAPACITY_EMPTY_ELEMENTDATA 声明的数组，注意此时初始容量是0，而不是大家以为的 10。
         * 注意：根据默认构造函数创建的集合，ArrayList list = new ArrayList();此时集合长度是0.
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         * 为什么ArrayList的最大数组大小是Integer.MAX_VALUE - 8？
         * 我估计是作者为了委托估计出来的8
         * 一般很少看到这个错误, 因为Java使用 int 类型作为数组的下标(index, 索引)。
         * 在Java中, int类型的最大值为 2^31 – 1 = 2,147,483,647。大多数平台的限制都约等于这个值 ——
         * 例如在 64位的 MB Pro 上, Java 1.7 平台可以分配长度为 2,147,483,645, 以及 Integer.MAX_VALUE-2) 的数组。
         * 平台不支持的原因可能是因为不同的JVM平台在对象头保存数组长度的方式，在计算头长度时对数组长度进行限制
         * OutOfMemoryError系列（7）: Requested array size exceeds VM limit
         * https://blog.csdn.net/renfufei/article/details/78170188
         * https://plumbr.io/outofmemoryerror/requested-array-size-exceeds-vm-limit
         *
         */

    }
}
