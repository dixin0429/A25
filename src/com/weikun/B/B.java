package com.weikun.B;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/6.
 * 子节点链表示法，
 */
public class B {

    private static class SonNode{
        //记录当前节点的位置
        private int pos;
        //子节点的中记录的下一个子节点的对象
        private SonNode next;
        public SonNode(int pos , SonNode next){
            this.pos = pos;//当前节点位置
            this.next = next;//下一节点位置
        }
    }


    //子节点链
    public static class Node{
        String data;
        //记录第一个子节点:用于保存对该子节点链的引用，通过这种关系 ，可以记录树中节点之间的父子关系。
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
    //使用一个Node[]数组来记录该树里的所有节点
    private Node[] nodes=new Node[this.treeSize];
    //记录节点数目
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
                if(parent.first==null){//如果没有孩子链
                    parent.first=new SonNode(i ,null);//还parent的儿子的第一个节点
                }else{//父节点有子节点，应该串到最后，在链接
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
