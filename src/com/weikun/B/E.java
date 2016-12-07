package com.weikun.B;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Created by Administrator on 2016/12/7.
 * 遍历二叉树，先序(DLR) 中序(LDR) 后序(LRD)
 */
public class E {
    class TreeNode{
        private String data;
        private TreeNode leftNode;
        private TreeNode rightNode;
        public TreeNode(String data,TreeNode leftNode,TreeNode rightNode){
            this.data=data;
            this.leftNode=leftNode;
            this.rightNode=rightNode;
        }
        public String getData(){
            return data;

        }

        public TreeNode getLeftNode(){
            return leftNode;
        }

        public TreeNode getRightNode(){
            return rightNode;
        }


    }

    //初始化二叉树
	/*
	 * 				    A
	 * 				/		\
	 * 			 B             C
	 * 			/ \          /   \
	 * 		   D    E       F       G
	 *             / \       \     /
	 * 			  H   I       J   P
	 *
	 */
    //深度优先遍历，实际上就是一个DLR
    public void depthOrderTraversal(){

        if(this.root==null){
            System.out.print("不能深度，因为没有根节点");
            return;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(this.root);
        while(stack.isEmpty()!=true){
            TreeNode node=stack.pop();
            System.out.println(node.data);
            if(node.rightNode!=null){
                stack.push(node.rightNode);
            }
            if(node.leftNode!=null){
                stack.push(node.leftNode);
            }

        }

    }
    //广度优先遍历
    public void levelOrderTraversal(){
        if(this.root==null){
            System.out.print("不能深度，因为没有根节点");
            return;
        }//使用队列功能，先进先出
        ArrayDeque<TreeNode> ad=new ArrayDeque<TreeNode>();

        ad.add(this.root);

        while(!ad.isEmpty()){

            TreeNode node=ad.remove();
            System.out.println(node.data);
            if(node.leftNode!=null){
                ad.add(node.leftNode);
            }
            if(node.rightNode!=null){
                ad.add(node.rightNode);
            }

        }

    }

        private TreeNode root;
    /*
	 * 				    A
	 * 				/		\
	 * 			 B             C
	 * 			/ \          /   \
	 * 		   D    E       F       G
	 *             / \       \     /
	 * 			  H   I       J   P
	 *
	 */
    @Test
    public void init(){
        TreeNode D=new TreeNode("D",null,null);
        TreeNode H=new TreeNode("H",null,null);
        TreeNode I=new TreeNode("I",null,null);
        TreeNode J=new TreeNode("J",null,null);
        TreeNode P=new TreeNode("P",null,null);
        TreeNode E=new TreeNode("E",H,I);
        TreeNode B=new TreeNode("B",D,E);
        TreeNode F=new TreeNode("F",null,J);
        TreeNode G=new TreeNode("G",P,null);
        TreeNode C=new TreeNode("C",F,G);
        TreeNode A=new TreeNode("A",B,C);

        this.root=A;
        //depthOrderTraversal();
        levelOrderTraversal();
//        pre(A);
//        System.out.println();
//        middle(A);
//        System.out.println();
//        suffix(A);

    }
    //先序 DLR
    public void pre(TreeNode node){
        System.out.print(node.data);
        if(node.leftNode!=null){
            this.pre(node.leftNode);
        }

        if(node.rightNode!=null){
            this.pre(node.rightNode);
        }


    }

    //中序 LDR
    public void middle(TreeNode node){

        if(node.leftNode!=null){
            this.middle(node.leftNode);
        }
        System.out.print(node.data);
        if(node.rightNode!=null){
            this.middle(node.rightNode);
        }


    }

    //后序 LRD
    public void suffix(TreeNode node){

        if(node.leftNode!=null){
            this.suffix(node.leftNode);
        }

        if(node.rightNode!=null){
            this.suffix(node.rightNode);
        }
        System.out.print(node.data);


    }

}
