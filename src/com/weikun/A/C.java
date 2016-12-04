package com.weikun.A;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 2016/12/4.
 * 找到其栈中的最小元素
 */
public class C {
    private Stack<Integer> stackData=new Stack<Integer>();
    private Stack<Integer> stackMin=new Stack<Integer>();

    public void push(Integer data){

        if(stackMin.isEmpty()){
            stackMin.push(data);
        }else{
            if(data<getMin()){

                stackMin.push(data);
            }

        }

        stackData.push(data);
    }
    public Integer getMin(){
        return stackMin.peek();
    }
    @Test
    public void test(){
        push(6);
        push(21);
        push(1);
        push(0);

        System.out.print(stackMin.peek());

    }

}
