package com.weikun.B;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/7.
 * 二叉树排序
 */
public class G {

    @Test
    public void test(){
        int arr[] = {1,5,4,3,2,6};
    /*
     * 		    1
     * 		     \
     *            5
     *          /   \
     *         4     6
     *        /
     *       3
     *      /
     *     2
     */

    }
    public void insert(G g,BSTNode node){




    }

    /**
     * 找到当前子节点的最大子节点
     * @param tree ：当前节点
     * @return 返回那个最大子节点
     */

    private BSTNode maximum(BSTNode tree){
        if(tree==null){
            return null;

        }
        while(tree.right!=null){

            tree=tree.right;
        }

        return tree;
    }

    /**
     *
     */
    public void pre(BSTNode node){//找到某个节点的前驱

    }

    /**
     * 找到当前子节点的最小子节点
     * @param tree ：当前节点
     * @return 返回那个最小子节点
     */

    private BSTNode minixum(BSTNode tree){
        if(tree==null){
            return null;

        }
        while(tree.left!=null){

            tree=tree.left;
        }

        return tree;
    }
    public void insert(String key){
        BSTNode z=new BSTNode(key,null,null,null);
        //如果新建节点失败，则返回
        if(z!=null){
            insert(this,z);
        }
    }

    public class BSTNode{
        String key;//关键字(键值)
        BSTNode left;//左孩子
        BSTNode right;//右孩子
        BSTNode parent;//父节点
        public BSTNode(String key,BSTNode parent,BSTNode left,BSTNode right){
            this.key=key;
            this.parent=parent;
            this.left=left;
            this.right=right;
        }
    }
}
