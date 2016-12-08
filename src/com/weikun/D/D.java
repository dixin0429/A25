package com.weikun.D;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/8.
 * ����ͼ���ڽӱ��ʾ����
 */
public class D {

    private class ENode {
        int tp;       // �ñ���ָ��Ķ����λ��
        ENode nextEdge; // ָ����һ������ָ��
    }

    // �ڽӱ��б�Ķ���
    private class VNode {
        String data;          // ������Ϣ
        ENode firstEdge;    // ָ���һ�������ö���Ļ�
    };
    private VNode[] top;  // ��������
    private int getPosition(String[] vexs,String key){
        for(int i=0;i< vexs.length;i++){
            if(vexs[i].equals(key)){

                return i;

            }
        }
        return -1;
    }
    /**
     *
     * @param vexs ���㼯��
     * @param edges �߼���
     */
    public void init(String[] vexs, String[][] edges){
        int len=vexs.length;
        int elent=edges.length;//�ߵĸ���
        top=new VNode[len];//���ռ�
        for(int i=0;i<len;i++){
            VNode node=new VNode();
            node.data=vexs[i];
            node.firstEdge=null;
            top[i]=node;//�����˶������顣

        }
        //��ʼ����
        for(int i=0;i<elent;i++){
            int pos1=this.getPosition(vexs ,edges[i][0]);//A
            int pos2=this.getPosition(vexs ,edges[i][1]);//B

            ENode eNode=new ENode();//A--B
            eNode.tp=pos2;
            if(top[pos1].firstEdge==null){//�Ѿ��нڵ���

                top[pos1].firstEdge=eNode;
            }else{
                linkNode(top[pos1].firstEdge,eNode);
            }

            ENode eNode2=new ENode();//B--A
            eNode2.tp=pos1;
            if(top[pos2].firstEdge==null){//

                top[pos2].firstEdge=eNode2;
            }else{
                linkNode(top[pos2].firstEdge,eNode2);
            }

        }


    }
    @Test
    public void test(){
        String[] vexs = {"V0", "V1", "V2", "V3"};
        String[][] edges = new String[][]{//����ͼ��ȫ����ʾ�ڵ�֮��Ĺ�ϵ����
                {"V0", "V1"},
                {"V0", "V2"},
                {"V0", "V3"},
                {"V1", "V2"},
                {"V3", "V2"}
        };
        // �Զ���"ͼ"(����������)
        //pG = new ListUDG();
        // �������е�"ͼ"
        this.init(vexs,edges);

        this.print();   // ��ӡͼ
    }
    private void linkNode(ENode o,ENode n){
        ENode t=o;
        while(o.nextEdge!=null ){
            o=o.nextEdge;
        }
        t.nextEdge=n;
    }

    /*
     * ��ӡ�������ͼ
     */
    public void print() {
        System.out.printf("List Graph:\n");
        //top��������
        for (int i = 0; i < top.length; i++) {
            System.out.printf("%d(%s): ", i, top[i].data);
            ENode node = top[i].firstEdge;//����Ķ���
            while (node != null) {         //node.tp�ñ���ָ��Ķ����������еĵ�λ��
                System.out.printf("%d(%s) ", node.tp, top[node.tp].data);
                node = node.nextEdge;
            }
            System.out.printf("\n");
        }
    }
}
