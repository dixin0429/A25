package com.weikun.B;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/6.
 * 演示 父节点表示法 表示一棵树
 */
public class A {

    public static class Node{
        //节点数据
        String data;
        //记录其父节点的位置
        int parent;

        public Node(String data , int parent){
            this.data = data;
            this.parent = parent;
        }
        public String toString(){
            return "父节点表示法[data=" + data + ", parent="+ parent + "]";
        }
    }

    //树节点的数量
    private int treeSize =100;
    //使用一个Node[]数组来记录该树里的所有节点
    private Node[]  nodes=new Node[this.treeSize];
    //记录节点数
    private int nodeNums;
    public A(){}


    /**
     *
     * @param node:要查找的节点
     * @return 该节点在数组中的索引号
     */

    public int pos(Node node){
        for(int i=0;i<this.treeSize;i++){
            if(nodes[i]==node){
                return i;
            }

        }
        return -1;
    }
    /**
     *
     * @param data :当前节点数据
     * @param parent 指定它的父亲是谁
     */
    public Node add(String data,Node parent){
        for(int i=0;i<this.treeSize;i++){
            if(nodes[i]==null){

                nodes[i]=new Node(data,this.pos(parent));
                this.nodeNums++;
                return nodes[i];
            }
        }
        return null;
    }
    public Node root(String data){
        nodes[0]=new Node(data,-1);
        this.nodeNums++;

        return nodes[0];
    }
    @Test
    public void test(){

        Node root=this.root("A");
        Node b=this.add("B",root);

        Node c=this.add("C",b);
        Node d=this.add("D",root);
        Node e=this.add("e",d);

        System.out.println(this.deep());

        List<Node> list=this.getChildren(root);
        for(Node node :list){
            System.out.println(node.data);
        }

    }
    /**
     *
     * @param parent:指定父节点
     * @return 当前父节点下的儿子。
     */
    public List<Node> getChildren(Node parent){
        List<Node> list=new ArrayList<Node>();
        for(int i=0;i<this.treeSize;i++){
            if(nodes[i]!=null&&nodes[i].parent==this.pos(parent)){
                list.add(nodes[i]);
            }

        }
        return list;


    }
    /**
     *
     * @return 该树的高度
     */
    public int deep(){
        int max=0;
        for(int i=0;i<this.treeSize&&nodes[i]!=null;i++){

            int count=1;
            int m=nodes[i].parent;
            //找到当前m所指的节点的父亲。，直到没有节点位置，或者到root节点为止。
            while(m!=-1&&nodes[m]!=null){

                m= nodes[m].parent;
                count++;
            }
            if(count>max){
               max=count;
            }


        }
        return max;

    }



}
