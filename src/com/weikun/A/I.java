package com.weikun.A;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 2016/12/4.
 * 用两个栈实现队列功能
 */

public class I {

    private Stack s1=new Stack();
    private Stack s2=new Stack();

    public void add(String data){
        s1.push(data);
    }
    public void push(){
        while(!s1.empty()){
            s2.push(s1.pop());
        }
    }
    @Test
    public void test(){
        add("A");
        add("B");
        add("C");
        push();
        pop();
    }
    public void pop(){
        while(!s2.empty()){
            System.out.print(s2.pop());
        }
    }
}
