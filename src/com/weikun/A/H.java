package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/4.
 * 链式的双向队列
 */
public class H {

    public class Node {//链结点
        String data;     //数据域
        Node next; //后继指针，结点           链域
        Node previous; //前驱指针，结点       链域
        Node(String data) {
            this.data = data;
        }
    }

    private Node front;     //首结点
    private Node rear;     //尾部指针


    public void insertFront(String data){
        Node newNode=new Node(data);
        if(front==null){//此队列没有节点
            rear=newNode;
        }else{//已经有节点了
            front.previous=newNode;
        }
        newNode.next=front;//老的手节点和新节点关联
        front=newNode;//新节点就是老节点

    }

    public void insertLast(String data){
        Node newNode=new Node(data);
        if(front==null){//此队列没有节点
            front=newNode;
        }else{//已经有节点了
            rear.next=newNode;
        }
        newNode.previous=rear;//老的手节点和新节点关联
        rear=newNode;//新节点就是老节点

    }
    public String deleteFront(){//c从头部删除
        Node node=front;
        front=node.next;
        if(front!=null){//至少有两个节点
            front.previous=null;

        }else{
            rear=null;
        }
        return node.data;

    }
    @Test
    public void test(){
        insertFront("A");
        insertFront("B");
        insertLast("C");
        insertFront("D");
        //DABC
        System.out.print(deleteRear());
        System.out.print(deleteFront());
    }
    public String deleteRear() {//从尾部删除
        Node node=rear;
        rear=node.previous;
        if(rear!=null){

            rear.next=null;
        }else{
            front=null;
        }
        return node.data;
    }




}
