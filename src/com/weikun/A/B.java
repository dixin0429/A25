package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/4.
 *  用Object[]自己写的栈，模拟stack
 */
public class B {
    @Test
    public void test(){
        push("A");
        push("B");
        push("C");

        System.out.print(pop());
        System.out.print(pop());
        System.out.print(peek());
    }

    private Object[] os=new Object[16];//

    private int size=0;//每次都加1


    public void push(Object data){
        if(size>=os.length){
            resize();
        }
        os[size++]=data;

    }
    public Object pop(){
        Object o=os[size-1];//因为数组是从0开始，
        os[--size]=null;

        return o;
    }

    public Object peek(){
        Object o=os[size-1];//因为数组是从0开始，
        return o;
    }
    private void resize() {
        Object[] temp=new Object[os.length*3];
        for(int i=0;i<os.length;i++){
            temp[i]=os[i];
            os[i]=null;
        }
        os=temp;
    }

}
