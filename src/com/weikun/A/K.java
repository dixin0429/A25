package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/6.
 * 双向链表
 */
public class K {

    private class Node {
        //保存节点的数据
        private String data;
        //指向上个节点的引用
        private Node prev;
        //指向下个节点的引用
        private Node next;

        //初始化全部属性的构造器
        public Node(String data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

    }

    //保存该链表的头节点
    private Node header;
    //保存该链表的尾节点
    private Node tail;
    //保存该链表中已包含的节点数
    private int size;

    //创建空链表
    public K() {
        //空链表，header和tail都是null
        header = null;
        tail = null;
    }

    //头查法
    public void addHeader(String data) {
        this.header = new Node(data, null, header);
        if (tail == null) {
            tail = header;

        }
        size++;

    }

    //在尾部插入
    public void addTail(String data) {
        if (header == null) {
            header = new Node(data, null, null);
        } else {
            Node node = new Node(data, tail, null);
            tail.next = node;
            tail = node;

        }
        size++;

    }

    /**
     * @param index:要即将插入节点的索引号
     * @return 返回索引指定的那个节点
     */
    public Node getNodeByIndex(int index) {
        Node currentNode = header;//代表从头找

        for (int i = 0; i < size; i++) {
            if (i == index) {//找到了

                return currentNode;
            }
            currentNode = currentNode.next;

        }

        return currentNode;

    }

    /**
     *
     * @param index 要删除节点的索引
     * @return 删除节点的数据
     */
    public String delete(int index){
        Node del=null;
        if(index==0){
            del=header;
            header=header.next;

        }else{//该链表，多于一个节点
            Node prev=this.getNodeByIndex(index-1);//要删除节点的前一个节点
            del=prev.next;
            prev.next=del.next;
            del.next.prev=del.prev;
        }

        del.next=null;
        del.prev=null;
        return del.data;

    }
    /**
     * @param data：要插入的数据内容
     * @param index         在该索引处插入
     */
    public void insert(String data, int index) {

        if (index < 0 || index >= size) {
            System.out.println("越界了");
        } else {
            if (header == null) {//该链式结构是否有节点，如果没有，先加一个
                this.addTail(data);

            } else {

                if (index == 0) {

                    this.addHeader(data);
                } else {
                    Node node = this.getNodeByIndex(index - 1);
                    Node current = new Node(data, node, node.next);
                    node.next.prev = current;
                    node.next = current;//先看右面，在赋值，插到老节点的下一个节点的前一个位置


                }
            }
            size++;

        }

    }
    @Test
    public void ok(){
        this.addHeader("A");
        this.addTail("B");
        this.addHeader("C");
        this.insert("D",1);
        this.delete(2);
        this.insert("E",1);
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        for(Node current=header;current!=null;current=current.next){

            sb.append(current.data);
        }


        return sb.toString();
    }
}
