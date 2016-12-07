package com.weikun.B;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/7.
 * ��������� �������洢
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

        this.root = new TreeNode(data);//ʵ����root
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
    //������
    private TreeNode root;
    //��Ĭ�ϵĹ�����������������

    /**
     * Ϊָ���ڵ�����ӽڵ㡣
     * @param index ��Ҫ����ӽڵ�ĸ��ڵ������
     * @param data ���ӽڵ������
     * @param isLeft �Ƿ�Ϊ��ڵ�
     * @return �����Ľڵ�
     */
    public TreeNode addNode(TreeNode parent , String data, boolean isLeft){
        if(parent==null){
            System.out.println("���������ӽڵ�");
            return null;
        }
        if( isLeft&&parent.left!=null ){
            System.out.println("���ӽڵ��Ѿ����ڣ��������");
            return null;
        }
        if( !isLeft&&parent.right!=null ){
            System.out.println("���ӽڵ��Ѿ����ڣ��������");
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
     * @param parent :Ҫ��ѯ�ĸ��ڵ�
     * @return �������ӽڵ�
     */
    public String left(TreeNode parent){
        if(parent.left!=null){
            return parent.left.data;
        }
        return null;
    }

    /**
     *
     * @param parent :Ҫ��ѯ�ĸ��ڵ�
     * @return �������ӽڵ�
     */
    public String right(TreeNode parent){
        if(parent.right!=null){
            return parent.right.data;
        }
        return null;
    }

    /**
     *
     * @param node:�жϵĵ�ǰ�ڵ�
     * @return ����ǰ�ڵ�����
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
