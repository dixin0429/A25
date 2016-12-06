package com.weikun.B;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/6.
 * ��ʾ ���ڵ��ʾ�� ��ʾһ����
 */
public class A {

    public static class Node{
        //�ڵ�����
        String data;
        //��¼�丸�ڵ��λ��
        int parent;

        public Node(String data , int parent){
            this.data = data;
            this.parent = parent;
        }
        public String toString(){
            return "���ڵ��ʾ��[data=" + data + ", parent="+ parent + "]";
        }
    }

    //���ڵ������
    private int treeSize =100;
    //ʹ��һ��Node[]��������¼����������нڵ�
    private Node[]  nodes=new Node[this.treeSize];
    //��¼�ڵ���
    private int nodeNums;
    public A(){}


    /**
     *
     * @param node:Ҫ���ҵĽڵ�
     * @return �ýڵ��������е�������
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
     * @param data :��ǰ�ڵ�����
     * @param parent ָ�����ĸ�����˭
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
     * @param parent:ָ�����ڵ�
     * @return ��ǰ���ڵ��µĶ��ӡ�
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
     * @return �����ĸ߶�
     */
    public int deep(){
        int max=0;
        for(int i=0;i<this.treeSize&&nodes[i]!=null;i++){

            int count=1;
            int m=nodes[i].parent;
            //�ҵ���ǰm��ָ�Ľڵ�ĸ��ס���ֱ��û�нڵ�λ�ã����ߵ�root�ڵ�Ϊֹ��
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
