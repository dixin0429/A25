package com.weikun.B;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/7.
 * 二叉链表的 二叉树存储
 */
public class D {


    public static class TreeNode{
        String data;
        TreeNode left;
        TreeNode right;
        public TreeNode(){
        }
        public TreeNode(String data){
            this.data = data;
        }
        public TreeNode(String data , TreeNode left, TreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public void init(String data){
        /*
              root
             /  \
            A   B
          / \
        C   D
         */

        this.root = new TreeNode(data);//实例化root
        TreeNode a=this.addNode(this.root,"A",true);
        TreeNode b=this.addNode(this.root,"B",false);
        TreeNode c=this.addNode(a,"C",true);
        TreeNode d=this.addNode(a,"D",false);

        System.out.println(this.left(a));
        System.out.println(this.right(a));

        System.out.print(this.deep(a));

    }
    @Test
    public void test(){
        init("Root");
    }
    //跟几点
    private TreeNode root;
    //以默认的构造器来创建二叉树

    /**
     * 为指定节点添加子节点。
     * @param index 需要添加子节点的父节点的索引
     * @param data 新子节点的数据
     * @param isLeft 是否为左节点
     * @return 新增的节点
     */
    public TreeNode addNode(TreeNode parent , String data, boolean isLeft){
        if(parent==null){
            System.out.println("不能增加子节点");
            return null;
        }
        if( isLeft&&parent.left!=null ){
            System.out.println("左子节点已经存在，不能添加");
            return null;
        }
        if( !isLeft&&parent.right!=null ){
            System.out.println("右子节点已经存在，不能添加");
            return null;
        }


        TreeNode node=new TreeNode(data);
        if(isLeft){
            parent.left=node;
        }else{
            parent.right=node;
        }
        return node;
    }

    /**
     *
     * @param parent :要查询的父节点
     * @return ：其左子节点
     */
    public String left(TreeNode parent){
        if(parent.left!=null){
            return parent.left.data;
        }
        return null;
    }

    /**
     *
     * @param parent :要查询的父节点
     * @return ：其右子节点
     */
    public String right(TreeNode parent){
        if(parent.right!=null){
            return parent.right.data;
        }
        return null;
    }

    /**
     *
     * @param node:判断的当前节点
     * @return ：当前节点的深度
     */
    public int deep(TreeNode node){
        if(node==null){
            return 0;
        }
        if(node.left==null&& node.right==null){
            return 1;
        }

        int leftddeep=deep(node.left);
        int rightdeep=deep(node.right);
        int max=0;
        max=leftddeep>rightdeep?leftddeep:rightdeep;

        return ++max;
    }
}
