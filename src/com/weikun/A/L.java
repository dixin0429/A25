package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/6.
 * Լɪ��
 */
public class L {

    //�����㣬
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    @Test
    public void init(){
        int n = 17;//����������n
        int m = 3;//�ͳ�Ȧ����m

        //��������һ���ڵ㣬�ڵ�ֵ��0
        Node first=new Node(0);
        Node last=first;

        for(int i=1;i<n;i++){//�γ�һ������
            last.next=new Node(i);
            last=last.next;

        }
        last.next=first;//�γ���β������Լɪ��

        //��ʼ��Ȧ

        while (last!=last.next){//����Ԫ�أ�

            for(int i=1;i<m;i++){

                last=last.next;
            }
            System.out.println("��Ȧ�ĺ���:"+last.next.data);
            last.next=last.next.next;//Ҫ����Ȧ����Խ��ȥ��

        }

        System.out.println("��������:"+last.data);
    }


}
