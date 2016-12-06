package com.weikun.B;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/6.
 * �ӽڵ�����ʾ����
 */
public class B {

    private static class SonNode{
        //��¼��ǰ�ڵ��λ��
        private int pos;
        //�ӽڵ���м�¼����һ���ӽڵ�Ķ���
        private SonNode next;
        public SonNode(int pos , SonNode next){
            this.pos = pos;//��ǰ�ڵ�λ��
            this.next = next;//��һ�ڵ�λ��
        }
    }


    //�ӽڵ���
    public static class Node{
        String data;
        //��¼��һ���ӽڵ�:���ڱ���Ը��ӽڵ��������ã�ͨ�����ֹ�ϵ �����Լ�¼���нڵ�֮��ĸ��ӹ�ϵ��
        SonNode first;
        public Node(String data){
            this.data = data;
            this.first = null;
        }
        public String toString(){
            if (first != null){
                return "TreeChild$Node[data=" + data + ", first="
                        + first.pos + "]";
            }else{
                return "TreeChild$Node[data=" + data + ", first=-1]";
            }
        }
    }

    private int treeSize = 100;
    //ʹ��һ��Node[]��������¼����������нڵ�
    private Node[] nodes=new Node[this.treeSize];
    //��¼�ڵ���Ŀ
    private int nodeNums;
    public Node root(String data){
        nodes[0]=new Node(data);
        this.nodeNums++;
        return nodes[0];
    }
    public Node addNode(String data , Node parent){

        for(int i=0;i<this.treeSize;i++){
            if(nodes[i]==null){
                nodes[i]=new Node(data);
                if(parent.first==null){//���û�к�����
                    parent.first=new SonNode(i ,null);//��parent�Ķ��ӵĵ�һ���ڵ�
                }else{//���ڵ����ӽڵ㣬Ӧ�ô������������
                    SonNode next=parent.first;
                    while(next.next!=null){
                        next=next.next;
                    }
                    next.next=new SonNode(i ,null);
                }
                this.nodeNums++;
                return nodes[i];
            }
        }
        return null;

    }
    @Test
    public void test(){

        Node root=this.root("A");

        Node b=this.addNode("B",root);
        Node c=this.addNode("C",root);


        Node d=this.addNode("D",b);
        System.out.println(this.deep(b));

        List <Node>list=this.getChildren(root);

        for(Node node :list){

            System.out.println(node.data);
        }



    }
    public List getChildren(Node parent){

        List list=new ArrayList();
        SonNode node=parent.first;

        while(node!=null){
            list.add(nodes[node.pos]);

            node=node.next;
        }


        return list;

    }
    private int deep(Node node){
        if(node.first==null){
            return 1;
        }else{
            SonNode son=node.first;
            int max=0;
            while(son!=null){

                int tmp=deep(nodes[son.pos]);

                if(tmp>max){
                    max=tmp;
                }
                son=son.next;
            }

            return ++max;
        }
    }
}
