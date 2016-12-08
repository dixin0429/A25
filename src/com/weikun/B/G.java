package com.weikun.B;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/7.
 * 二叉树排序
 */
public class G {
    private BSTNode root;




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
     *
     * @param node 要查此节点的后继节点
     * @return ：此节点的后继节点，其该节点右子树的最小节点
     */

    public BSTNode suf(BSTNode node){
        if(node.right!=null){
            return this.minixum(node.right);
        }
        //如果没有右孩子，则x有以下两种可能
        //1.x是一个左孩子，则x的后继节点为它的父节点
        //2.x是一个右孩子，则查找x的最低父节点，并且该父节点要具有左孩子，找到的这个最低的父节点就是x的后继节点
        BSTNode p=node.parent;
        while(p!=null && node==p.right){
            node=p;
            p=p.parent;

        }

        return p;

    }

    /**找到某个节点的前驱
     * 实际上就是该节点的左子树的最大节点
     *
     */
    public BSTNode pre(BSTNode node){
        if(node.left!=null){
            this.maximum(node.left);

        }
        //如果x没有左孩子，则x有以下两种可能：
        //1.x是一个右孩子，则x的前驱节点为它的父节点
        //2.x是一个左孩子，则查找x的最低的父节点，并且该节点要具有右孩子(因为都比他大)，
        //找到的这个最低的父节点就是x的前驱节点
        //其实就是，该节点左子树为空, 则其前驱为：其祖先节点(递归), 且该祖先节点的右孩子也是其祖先节点
        //  通俗的说，一直往上找找到最后出现左拐那次后的祖先节点;

        if(node.left==null && node.parent==null){
            System.out.println("没有前驱");
            return null;
        }
        //以下就是其父亲不等于null
        BSTNode p=node.parent;//取出父亲
        while((p!=null && node==p.left)){//node是它父亲的左孩子
            node=p;
            p=p.parent;
        }

        return p;
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

    }
    /**
     *
     * @param  :要插入的树结构
     * @param node：要插入的节点
     */
    public void insert(BSTNode node){

        BSTNode x=this.root;//根节点
        BSTNode y=null;
        //找到具体插入节点将是哪个节点的儿子。
        while(x!=null){//代表已经有根节点了
            y=x;
            int r=node.key.compareTo(x.key);//结果，如果r>0一定加在x的右子树中，反之加在左子树中。
            if(r>0){
                x=x.right;
            }else if(r<0){
                x=x.left;
            }else{
                System.out.println("二叉排序树的节点值不能相同。");
                return;
            }
        }
        //当退出循环之后，x=null，y就是x退出之前的那个节点，正好做新节点的父亲
        node.parent=y;

        if(y==null ){//根节点
            this.root=node;
        }else{//到底新节点插在y的哪个子树中

            int r=node.key.compareTo(y.key);
            if(r>0){
                y.right=node;
            }else if(r<0){
                y.left=node;
            }else{
                return;
            }

        }



    }

    /**
     *
     *
     * @param node 要删除的节点
     */
    public void del(BSTNode node){
        BSTNode x=null;
        BSTNode y=null;
        if(node.left==null || node.right==null){//没有左子或没有右子
            y=node;
        }else{//既有左子又有右子
            y=this.suf(node);//先找到它的后继节点，
        }

        if(y.left!=null){
            x=y.left;
        }
        if (y.right!=null){
            x=y.right;
        }
        if(x!=null){//有左子或者有右子
            x.parent=y.parent;
        }
        if(y.parent==null){//y就是根节点
            this.root = x;//y就是根节点，那么y没了，直接替补的就是x
        }else if(y==y.parent.left){//y是否是y的左子结点啊？如果这个条件为真，y一定是要删除节点的后继节点
            y.parent.left=x;
        }else{
            y.parent.right=x;
        }
        if(y!=node){
            node.key=y.key;
        }

    }


    /*递归实现，查找二叉树x中键值为key的节点
	 *
	 */
    private BSTNode search(BSTNode x,String key){
        if(x==null){
            return x;
        }
        int r=key.compareTo(x.key);
        if(r>0){
            return search(x.right,key);
        }else if(r<0){
            return search(x.left,key);
        }else{
            return x;
        }

    }

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
        for(int i=0;i<arr.length;i++){
            BSTNode node=new BSTNode(arr[i]+"",null,null,null);
            this.insert(node);

        }
        BSTNode node=this.search(this.root,arr[1]+"");
        this.del(node);
        this.postOrder(this.root);
        System.out.println();
        this.preOrder(this.root);



    }
    //前序遍历DLR
    private void preOrder(BSTNode tree){
        if(tree!=null){
            System.out.print(tree.key+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }


    }

    //中序遍历 LDR
    private void inOrder(BSTNode tree){
        if(tree!=null){
            inOrder(tree.left);
            System.out.print(tree.key+" ");
            inOrder(tree.right);
        }
    }
    //后序遍历 LRD
    private void postOrder(BSTNode tree){
        if(tree!=null){
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key+" ");
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
