package com.weikun.B;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/7.
 * ����������
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
     * �ҵ���ǰ�ӽڵ������ӽڵ�
     * @param tree ����ǰ�ڵ�
     * @return �����Ǹ�����ӽڵ�
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
    public void pre(BSTNode node){//�ҵ�ĳ���ڵ��ǰ��

    }

    /**
     * �ҵ���ǰ�ӽڵ����С�ӽڵ�
     * @param tree ����ǰ�ڵ�
     * @return �����Ǹ���С�ӽڵ�
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
        //����½��ڵ�ʧ�ܣ��򷵻�
        if(z!=null){
            insert(this,z);
        }
    }

    public class BSTNode{
        String key;//�ؼ���(��ֵ)
        BSTNode left;//����
        BSTNode right;//�Һ���
        BSTNode parent;//���ڵ�
        public BSTNode(String key,BSTNode parent,BSTNode left,BSTNode right){
            this.key=key;
            this.parent=parent;
            this.left=left;
            this.right=right;
        }
    }
}
