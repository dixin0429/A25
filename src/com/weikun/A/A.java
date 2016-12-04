package com.weikun.A;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Stack;

/**
 * Created by Administrator on 2016/12/4.
 * 使用JDK自带的Stack完成栈功能
 */
public class A {
    @Test
    public void test(){
        Stack s=new Stack();

        s.push(100);

        s.push(200);

        s.push("A");

        s.push(100.1f);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());


//        Enumeration es=s.elements();
//
//        while(es.hasMoreElements()){
//            System.out.println(es.nextElement());
//        }
    }
}
