package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/6.
 * 约瑟夫环
 */
public class L {

    //定义结点，
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    @Test
    public void init(){
        int n = 17;//定义总人数n
        int m = 3;//和出圈数字m

        //先声明第一个节点，节点值是0
        Node first=new Node(0);
        Node last=first;

        for(int i=1;i<n;i++){//形成一个链表
            last.next=new Node(i);
            last=last.next;

        }
        last.next=first;//形成首尾相连的约瑟夫环

        //开始跳圈

        while (last!=last.next){//还有元素，

            for(int i=1;i<m;i++){

                last=last.next;
            }
            System.out.println("出圈的号是:"+last.next.data);
            last.next=last.next.next;//要把跳圈的人越过去，

        }

        System.out.println("幸运者是:"+last.data);
    }


}
