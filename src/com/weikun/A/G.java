package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/4.
 * 链式单向队列
 */
public class G {

    //定义一个内部类Node，Node实例代表链队列的节点。
    private class Node{
        //保存节点的数据
        private String data;
        //指向下个节点的引用
        private Node next;

        //初始化全部属性的构造器
        public Node(String data ,  Node next){
            this.data = data;
            this.next = next;
        }
    }

    //保存该链队列的头节点
    private Node front;
    //保存该链队列的尾节点
    private Node rear;
    //保存该链队列中已包含的节点数
    private int size;


    public void add(String data){
        if(front==null){
            front=new Node(data,null);
            rear=front;
        }else{
            Node newNode=new Node(data,null);//新节点

            rear.next=newNode;
            rear=newNode;
        }
        size++;

    }
    public G(){

    }
    @Test
    public void test(){
        add("A");
        add("B");
        add("C");
        System.out.print(remove());
        System.out.print(remove());

    }
    public String remove(){//删除节点，从front删
        Node oldNode=front;
        front=front.next;//其新节点的地址就是新的front
        oldNode.next=null;        //删除老节点
        size--;
        return oldNode.data;

    }
}
