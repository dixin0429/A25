package com.weikun.A;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2016/12/4.
 *  实现顺序队列,
 */
public class E {

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
        elementData=new String[10];
        capacity=elementData.length-1;
    }
    public String remove() {//删除
        String s=elementData[front];
        elementData[front++]=null;
        return s;
    }
    @Test
    public void test(){
        add("A");
        add("B");
        add("C");

        System.out.print(remove());
        System.out.print(remove());

    }
    public void add(String data) {
        if(rear>capacity){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData[rear++]=data;
    }
}
