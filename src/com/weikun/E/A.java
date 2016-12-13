package com.weikun.E;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/13.
 * ƽ�������
 */
public class A {
    private static String arr[]= {"3","2","1","4","5","6","7","9","8"};

    @Test

    public void test(){
        int i;
        A tree = new A();

        System.out.printf("== �������: ");
        for(i=0; i<arr.length; i++) {
            //tree.insert(arr[i]);
            tree.mRoot=tree.insert(tree.mRoot,arr[i]);
            System.out.printf("%s ", arr[i]);
        }
        System.out.println("pok");
        System.out.printf("\n== ǰ�����: ");
        tree.preOrder(tree.mRoot);
          System.out.printf("\n== �������: ");
          tree.inOrder(tree.mRoot);
        System.out.printf("\n== �������: ");
        tree.suffixOrder(tree.mRoot);


    }

    private AVLTreeNode mRoot;    // �����
    // AVL���Ľڵ�(�ڲ���)
    class AVLTreeNode {
        String key;                // �ؼ���(��ֵ)
        int height;         // ��ǰ�ڵ����ӽڵ�����߶�
        AVLTreeNode left;    // ����
        AVLTreeNode right;    // �Һ���

        public AVLTreeNode(String key, AVLTreeNode left, AVLTreeNode right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    /*
	 * LR�����Ҷ�Ӧ�����(��˫��ת)��--��ӦRR-LL
	 *(����ڵ������������ұ߽ڵ�)
	 * ����ֵ����ת��ĸ��ڵ�
	 */
    private AVLTreeNode leftRightRotation(AVLTreeNode ka) {
        ka.left=this.rightRightRotation(ka.left);
        return this.leftLeftRotation(ka);
    }


    /*
    * ǰ�����"AVL��"
    * DLR
    */
    private void preOrder(AVLTreeNode tree) {
        if(tree != null){
            System.out.print(tree.key+" ");
            preOrder(tree.left);
            preOrder(tree.right);


        }
    }

    /*
    * �������"AVL��"
    * LRD
    */
    private void suffixOrder(AVLTreeNode tree) {
        if(tree != null){
            suffixOrder(tree.left);
            suffixOrder(tree.right);
            System.out.print(tree.key+" ");

        }
    }

    /*
	 * �������"AVL��"
	 * LDR
	 */
    private void inOrder(AVLTreeNode tree) {
        if(tree != null){
            inOrder(tree.left);
            System.out.print(tree.key+" ");
            inOrder(tree.right);
        }
    }


    private AVLTreeNode insert(AVLTreeNode tree, String key) {

        if(tree==null){
            tree=new AVLTreeNode(key,null,null);
        }else{//
            int cmp=key.compareTo(tree.key);
            if(cmp<0){
                tree.left=this.insert(tree.left,key);

                //�ж����������Ƿ�ƽ��
                if(this.height(tree.left)-this.height(tree.right)==2){
                    if(key.compareTo(tree.left.key)<0){//LLL
                        tree=this.leftLeftRotation(tree);

                    }else{
                        tree=this.leftRightRotation(tree);
                    }

                }
            }else if(cmp>0){
                tree.right=this.insert(tree.right,key);
                if(this.height(tree.right)-this.height(tree.left)==2){
                    if(key.compareTo(tree.right.key)<0) {//
                        tree=this.rightLeftRotation(tree);
                    }else{
                        tree=this.rightRightRotation(tree);
                    }

                }
            }else{
                System.out.println("���������ͬ�ڵ㣡");
            }


        }
        tree.height=max(height(tree.left),height(tree.right))+1;


        return tree;
    }

    /*
 * RL�������Ӧ�����(��˫��ת)����Ӧ LL-RR
 *(����ڵ�������������߽ڵ�)
 * ����ֵ����ת��ĸ��ڵ�
 */
    private AVLTreeNode rightLeftRotation(AVLTreeNode k1) {

        k1.right=leftLeftRotation(k1.right);
        return rightRightRotation(k1);
    }


    /*
	 * RR�����Ҷ�Ӧ�����(�ҵ���ת)��
	 *
	 *      -2                              0
	 *     A                               B
	 *      \ -1                         /0  \0
	 *       B         -->>RR--->>      A     X
	 *     /  \ 0                        \
	 *    C    X                          C
	 *
	 *(����ڵ������������ұ߽ڵ�)
	 * ����ֵ����ת��ĸ��ڵ�
	 */

    private AVLTreeNode  rightRightRotation(AVLTreeNode ka) {
        AVLTreeNode kb=null;
        kb=ka.right;


        ka.right=kb.left;
        kb.left=ka;


        //�����½ڵ�ĸ߶�
        ka.height=max(height(ka.left),height(ka.right))+1;
        kb.height=max(ka.height,height(kb.right))+1;
        return kb;
    }

    /*
      * LL�������Ӧ�����(����ת--��˳ʱ����ת)��
      *        2
      *     A                     B
      *    /  1                 /   \
      *   B   -->>LL--->>      X     A
      *  /  \                       /
      * X   C                      C
      * ����ֵ����ת��ĸ��ڵ�
      * (����Ľڵ�������������߽ڵ�)
      */
    private AVLTreeNode leftLeftRotation(AVLTreeNode ka) {//Ka��A
        AVLTreeNode kb=null;

        kb=ka.left;
        ka.left=kb.right;
        kb.right=ka;
        //�����½ڵ�ĸ߶�
        ka.height=max(height(ka.left),height(ka.right))+1;
        kb.height=max(ka.height,height(kb.left))+1;
        return kb;
    }
//    private AVLTreeNode leftLeftRotation(AVLTreeNode k2) {//K2��A
//        AVLTreeNode k1;//B
//
//        k1 = k2.left;
//        k2.left = k1.right;//K1��û���ҽڵ㣬null
//        k1.right = k2;
//        //���ڸ߶ȣ����ĸ߶ȼ�Ϊ����Ρ�
//        //���յĶ������ĸ߶���0���ǿ����ĸ߶ȴ�1�������������������(���Ĳ��Ϊ1�������ӽڵ�Ϊ��2�㣬��������)��
//        k2.height = max( height(k2.left), height(k2.right)) + 1;
//        k1.height = max( height(k1.left), k2.height) + 1;//���ұȽ�
//
//        return k1;
//    }

    /*
	 * ��ȡ���ĸ߶�
	 */
    private int height(AVLTreeNode tree) {
        if (tree != null){
            return tree.height;
        }

        return 0;
    }

    /*
	 * �Ƚ������ڵ��height������ֵ�Ĵ�С
	 */
    private int max(int a, int b) {
        return a>b ? a : b;
    }



}
