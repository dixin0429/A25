package com.weikun.B;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/7.
 * ����������
 */
public class G {
    private BSTNode root;




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
     *
     * @param node Ҫ��˽ڵ�ĺ�̽ڵ�
     * @return ���˽ڵ�ĺ�̽ڵ㣬��ýڵ�����������С�ڵ�
     */

    public BSTNode suf(BSTNode node){
        if(node.right!=null){
            return this.minixum(node.right);
        }
        //���û���Һ��ӣ���x���������ֿ���
        //1.x��һ�����ӣ���x�ĺ�̽ڵ�Ϊ���ĸ��ڵ�
        //2.x��һ���Һ��ӣ������x����͸��ڵ㣬���Ҹø��ڵ�Ҫ�������ӣ��ҵ��������͵ĸ��ڵ����x�ĺ�̽ڵ�
        BSTNode p=node.parent;
        while(p!=null && node==p.right){
            node=p;
            p=p.parent;

        }

        return p;

    }

    /**�ҵ�ĳ���ڵ��ǰ��
     * ʵ���Ͼ��Ǹýڵ�������������ڵ�
     *
     */
    public BSTNode pre(BSTNode node){
        if(node.left!=null){
            this.maximum(node.left);

        }
        //���xû�����ӣ���x���������ֿ��ܣ�
        //1.x��һ���Һ��ӣ���x��ǰ���ڵ�Ϊ���ĸ��ڵ�
        //2.x��һ�����ӣ������x����͵ĸ��ڵ㣬���Ҹýڵ�Ҫ�����Һ���(��Ϊ��������)��
        //�ҵ��������͵ĸ��ڵ����x��ǰ���ڵ�
        //��ʵ���ǣ��ýڵ�������Ϊ��, ����ǰ��Ϊ�������Ƚڵ�(�ݹ�), �Ҹ����Ƚڵ���Һ���Ҳ�������Ƚڵ�
        //  ͨ�׵�˵��һֱ�������ҵ�����������Ǵκ�����Ƚڵ�;

        if(node.left==null && node.parent==null){
            System.out.println("û��ǰ��");
            return null;
        }
        //���¾����丸�ײ�����null
        BSTNode p=node.parent;//ȡ������
        while((p!=null && node==p.left)){//node�������׵�����
            node=p;
            p=p.parent;
        }

        return p;
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

    }
    /**
     *
     * @param  :Ҫ��������ṹ
     * @param node��Ҫ����Ľڵ�
     */
    public void insert(BSTNode node){

        BSTNode x=this.root;//���ڵ�
        BSTNode y=null;
        //�ҵ��������ڵ㽫���ĸ��ڵ�Ķ��ӡ�
        while(x!=null){//�����Ѿ��и��ڵ���
            y=x;
            int r=node.key.compareTo(x.key);//��������r>0һ������x���������У���֮�����������С�
            if(r>0){
                x=x.right;
            }else if(r<0){
                x=x.left;
            }else{
                System.out.println("�����������Ľڵ�ֵ������ͬ��");
                return;
            }
        }
        //���˳�ѭ��֮��x=null��y����x�˳�֮ǰ���Ǹ��ڵ㣬�������½ڵ�ĸ���
        node.parent=y;

        if(y==null ){//���ڵ�
            this.root=node;
        }else{//�����½ڵ����y���ĸ�������

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
     * @param node Ҫɾ���Ľڵ�
     */
    public void del(BSTNode node){
        BSTNode x=null;
        BSTNode y=null;
        if(node.left==null || node.right==null){//û�����ӻ�û������
            y=node;
        }else{//����������������
            y=this.suf(node);//���ҵ����ĺ�̽ڵ㣬
        }

        if(y.left!=null){
            x=y.left;
        }
        if (y.right!=null){
            x=y.right;
        }
        if(x!=null){//�����ӻ���������
            x.parent=y.parent;
        }
        if(y.parent==null){//y���Ǹ��ڵ�
            this.root = x;//y���Ǹ��ڵ㣬��ôyû�ˣ�ֱ���油�ľ���x
        }else if(y==y.parent.left){//y�Ƿ���y�����ӽ�㰡������������Ϊ�棬yһ����Ҫɾ���ڵ�ĺ�̽ڵ�
            y.parent.left=x;
        }else{
            y.parent.right=x;
        }
        if(y!=node){
            node.key=y.key;
        }

    }


    /*�ݹ�ʵ�֣����Ҷ�����x�м�ֵΪkey�Ľڵ�
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
    //ǰ�����DLR
    private void preOrder(BSTNode tree){
        if(tree!=null){
            System.out.print(tree.key+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }


    }

    //������� LDR
    private void inOrder(BSTNode tree){
        if(tree!=null){
            inOrder(tree.left);
            System.out.print(tree.key+" ");
            inOrder(tree.right);
        }
    }
    //������� LRD
    private void postOrder(BSTNode tree){
        if(tree!=null){
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key+" ");
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
