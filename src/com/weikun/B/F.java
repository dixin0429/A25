package com.weikun.B;

import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2016/12/7.
 * 实现哈夫曼树
 */
public class F {
    /**
     *
     * @param list 所有节点列表
     * @return 返回经过哈夫曼运算后最后的那个剩余节点
     */
    public Node  createTree(List<Node> list){
        while(list.size()>1){

            Collections.sort(list);
            Node left=list.get(0);//左子
            Node right=list.get(1);//右子
            Node parent=new Node(left.data+right.data,left.weight+right.weight);//形成新节点
            parent.left=left;
            parent.right=right;
            list.remove(left);
            list.remove(right);
            list.add(parent);
        }
        return list.get(0);
    }
    public void levelOrderTraversal(Node node1){

        ArrayDeque<Node> ad=new ArrayDeque<Node>();
        if(node1==null){
            System.out.print("不能深度，因为没有根节点");
            return;
        }//使用队列功能，先进先出


        ad.add(node1);

        while(!ad.isEmpty()){

            Node node=ad.remove();
            System.out.println(node.data+"--"+node.weight);
            if(node.left!=null){
                ad.add(node.left);
            }
            if(node.right!=null){
                ad.add(node.right);
            }

        }

    }
    /**
     * 对哈夫曼树进行初始化
     */
    @Test
    public void init(){

        List<Node> list=new ArrayList<>();

        list.add(new Node("A",6));
        list.add(new Node("B",7));
        list.add(new Node("C",13));
        list.add(new Node("D",16));
        list.add(new Node("E",18));
        list.add(new Node("F",30));



        levelOrderTraversal(this.createTree(list));

    }



    class Node implements Comparable<Node> {
        private String data;
        private double weight;  //权重
        private Node left;
        private Node right;

        public Node(String data, double weight) {
            this.data = data;
            this.weight = weight;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "data:" + this.data + ";weight:" + this.weight;
        }

        @Override
        public int compareTo(Node other) {
            if (this.getWeight() > other.getWeight()) {
                return 1;
            }
            if (this.getWeight() < other.getWeight()) {
                return -1;
            }

            return 0;
        }

    }




}
