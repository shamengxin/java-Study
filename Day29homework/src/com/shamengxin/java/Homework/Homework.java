package com.shamengxin.java.Homework;
/*编写程序实现单向链表数据结构：
public class Node {
    Object data;
    Node next;
}
public class MyLinkedList{
    Node header;
        ....
    // 添加数据的方法
    // 删除数据的方法
    // 修改数据的方法
    // 查找数据的方法
    // 打印集合中每个元素的方法
}
    最后编写测试程序*/
public class Homework {
    public static void main(String[] args) {
        MyLinkedList mll=new MyLinkedList();
        mll.add("abc");
        mll.add(3.14);
        mll.add(true);
        mll.add(new Object());

        Node node=mll.find("abc");
        System.out.println(node.data);

        mll.delete(3.14);

        mll.print();
    }
}
