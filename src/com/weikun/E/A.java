package com.weikun.E;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/13.
 * 平衡二叉树
 */
public class A {
    private static String arr[]= {"3","2","1","4","5","6","7","9","8"};

    @Test

    public void test(){
        int i;
        A tree = new A();

        System.out.printf("== 依次添加: ");
        for(i=0; i<arr.length; i++) {
            //tree.insert(arr[i]);
            tree.mRoot=tree.insert(tree.mRoot,arr[i]);
            System.out.printf("%s ", arr[i]);
        }
        System.out.println("pok");
        System.out.printf("\n== 前序遍历: ");
        tree.preOrder(tree.mRoot);
          System.out.printf("\n== 中序遍历: ");
          tree.inOrder(tree.mRoot);
        System.out.printf("\n== 后序遍历: ");
        tree.suffixOrder(tree.mRoot);


    }

    private AVLTreeNode mRoot;    // 根结点
    // AVL树的节点(内部类)
    class AVLTreeNode {
        String key;                // 关键字(键值)
        int height;         // 当前节点中子节点的最大高度
        AVLTreeNode left;    // 左孩子
        AVLTreeNode right;    // 右孩子

        public AVLTreeNode(String key, AVLTreeNode left, AVLTreeNode right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    /*
	 * LR：左右对应的情况(左双旋转)。--对应RR-LL
	 *(插入节点是左子树的右边节点)
	 * 返回值：旋转后的根节点
	 */
    private AVLTreeNode leftRightRotation(AVLTreeNode ka) {
        ka.left=this.rightRightRotation(ka.left);
        return this.leftLeftRotation(ka);
    }


    /*
    * 前序遍历"AVL树"
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
    * 后序遍历"AVL树"
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
	 * 中序遍历"AVL树"
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

                //判断左右子树是否平衡
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
                System.out.println("不能添加相同节点！");
            }


        }
        tree.height=max(height(tree.left),height(tree.right))+1;


        return tree;
    }

    /*
 * RL：右左对应的情况(右双旋转)。对应 LL-RR
 *(插入节点是右子树的左边节点)
 * 返回值：旋转后的根节点
 */
    private AVLTreeNode rightLeftRotation(AVLTreeNode k1) {

        k1.right=leftLeftRotation(k1.right);
        return rightRightRotation(k1);
    }


    /*
	 * RR：右右对应的情况(右单旋转)。
	 *
	 *      -2                              0
	 *     A                               B
	 *      \ -1                         /0  \0
	 *       B         -->>RR--->>      A     X
	 *     /  \ 0                        \
	 *    C    X                          C
	 *
	 *(插入节点是右子树的右边节点)
	 * 返回值：旋转后的根节点
	 */

    private AVLTreeNode  rightRightRotation(AVLTreeNode ka) {
        AVLTreeNode kb=null;
        kb=ka.right;


        ka.right=kb.left;
        kb.left=ka;


        //计算新节点的高度
        ka.height=max(height(ka.left),height(ka.right))+1;
        kb.height=max(ka.height,height(kb.right))+1;
        return kb;
    }

    /*
      * LL：左左对应的情况(左单旋转--右顺时针旋转)。
      *        2
      *     A                     B
      *    /  1                 /   \
      *   B   -->>LL--->>      X     A
      *  /  \                       /
      * X   C                      C
      * 返回值：旋转后的根节点
      * (插入的节点是左子树的左边节点)
      */
    private AVLTreeNode leftLeftRotation(AVLTreeNode ka) {//Ka是A
        AVLTreeNode kb=null;

        kb=ka.left;
        ka.left=kb.right;
        kb.right=ka;
        //计算新节点的高度
        ka.height=max(height(ka.left),height(ka.right))+1;
        kb.height=max(ka.height,height(kb.left))+1;
        return kb;
    }
//    private AVLTreeNode leftLeftRotation(AVLTreeNode k2) {//K2是A
//        AVLTreeNode k1;//B
//
//        k1 = k2.left;
//        k2.left = k1.right;//K1并没有右节点，null
//        k1.right = k2;
//        //关于高度，树的高度即为最大层次。
//        //即空的二叉树的高度是0，非空树的高度从1计数，等于它的最大层次(根的层次为1，根的子节点为第2层，依次类推)。
//        k2.height = max( height(k2.left), height(k2.right)) + 1;
//        k1.height = max( height(k1.left), k2.height) + 1;//左右比较
//
//        return k1;
//    }

    /*
	 * 获取树的高度
	 */
    private int height(AVLTreeNode tree) {
        if (tree != null){
            return tree.height;
        }

        return 0;
    }

    /*
	 * 比较两个节点的height的两个值的大小
	 */
    private int max(int a, int b) {
        return a>b ? a : b;
    }



}
