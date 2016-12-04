package com.weikun.A;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2016/12/4.
 *  循环队列,允许覆盖
 */
public class F {


    //默认长度
    private int DEFAULT_SIZE = 10;
    //保存数组的长度。
    private int capacity;
    //定义一个数组用于保存顺序队列的元素
    private String[] elementData;
    //保存顺序队列中元素的当前个数
    private int front = 0;//出
    private int rear = 0;//进
    @Before
    public void init(){
        elementData=new String[3];
        capacity=elementData.length;
    }

    public void add(String data){

        elementData[rear++]=data;
        rear=capacity==rear?0:rear;
    }
    @Test
    public void test(){
        add("A");
        add("B");
        add("C");

        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());

    }
    public String remove(){

        String s=elementData[front];
        elementData[front++]=null;
        front=front==capacity?0:front;
        return s;
    }
}
