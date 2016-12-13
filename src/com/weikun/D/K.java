package com.weikun.D;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2016/12/13.
 * ����ͼ����������
 */
public class K {

    // �ڽӱ��б��Ӧ������Ķ���
    private class ENode {
        int itop;       // �ñ���ָ��Ķ����λ��
        ENode next; // ָ����һ������ָ��
    }

    // �ڽӱ��б�Ķ���
    private class VNode {
        char data;          // ������Ϣ
        ENode firstEdge;    // ָ���һ�������ö���Ļ�
    };

    private List<VNode> mVexs;  // ��������

    @Test
    public void test(){
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};//��������
        char[][] edges = new char[][]{//�����飬����A->G B->A��
                {'A', 'G'},
                {'B', 'A'},
                {'B', 'D'},
                {'C', 'F'},
                {'C', 'G'},
                {'D', 'E'},
                {'D', 'F'}
        };

        int vlen=vexs.length;
        int elen=edges.length;
        mVexs=new ArrayList<VNode>();
        //��ʼ�����㼯��
        for(int i=0;i<vlen;i++){
            VNode vNode=new VNode();
            vNode.data=vexs[i];
            vNode.firstEdge=null;
            mVexs.add(vNode);//�����ж���������붥�㼯��
        }
        //��ʼ���߼���

        for(int i=0;i<elen;i++){
            char c1=edges[i][0];//A
            char c2=edges[i][1];//G

            int p1=this.getPosition(c1);//A��λ��
            int p2=this.getPosition(c2);//G��λ��

            ENode eNode=new ENode();
            eNode.itop=p2;

            if(this.mVexs.get(p1).firstEdge==null){//Aָ��ĳ��Ƚڵ� ��һ�ι���
                this.mVexs.get(p1).firstEdge=eNode;
            }else{//�����ж��Aָ��ĳ��Ƚڵ㣬��ι���
                ENode old=this.mVexs.get(p1).firstEdge;
                this.linkedLast(old,eNode);

            }



        }
        sort();

    }
    public void sort(){
        int vlen=this.mVexs.size();//�������
        int index=0;
        int rudu[]=new int[vlen];//�������

        char[] results  = new char[vlen];//��������������

        //ͳ��ÿ�������������飬����rudu��Ĭ��ÿ��Ԫ�ض���0��ͨ��ͳ��
        //ÿ���������ȣ���ÿ��Ԫ��++
        for(int i=0;i<vlen;i++){

            ENode edge=this.mVexs.get(i).firstEdge;//ȡ����һ�����ĵ�ַ
            //�γɸ��������
            while(edge!=null){//�����л�

                rudu[edge.itop]++;
                edge=edge.next;
            }

        }
        //���������Ϊ��Ķ��㣬�����
        Queue<Integer> queue = new LinkedList<Integer>();// ��������
        //���Ϊ�������
        for(int i=0;i<vlen;i++){
            if(rudu[i]==0){
                queue.add(i);
            }
        }
        //���
        while(!queue.isEmpty()){

            int i=queue.poll();
            results[index++]=this.mVexs.get(i).data;//�ҵ������Ϊ0�ĵ�

            ENode eNode=this.mVexs.get(i).firstEdge;//G

            //��ߺ��ģ�ʵ���Ͼ�����rudu����ָ����������--
            while(eNode!=null){

                //VNode vNode=this.mVexs.get(eNode.itop);

                rudu[eNode.itop]--;
                if(rudu[eNode.itop]==0){
                    queue.add(eNode.itop);
                }

                eNode=eNode.next;


            }



        }
        if(index!=vlen){
            System.out.println("���֮���Ǹ��������ܽ�����ж");
        }

        // ��ӡ����������
        System.out.printf("== TopSort: ");
        for(int i = 0; i < vlen; i ++){
            System.out.printf("%c ", results[i]);
        }
        System.out.printf("\n");


    }

    /**
     *
     * @param old �Ͻڵ�
     * @param newnode �½ڵ��ַ
     */
    private void linkedLast(ENode old,ENode newnode){
        ENode o=old;
        while(o.next!=null){

            o=o.next;
        }
        o.next=newnode;
    }
    /**
     *
     * @param c:Ҫ���ҵ��ַ�
     * @return�����ڶ��������е�λ��
     */
    public int getPosition(char c){
        for(int i=0;i<this.mVexs.size();i++){
            if(this.mVexs.get(i).data==c){//�ҵ���
                return i;
            }

        }
        return -1;
    }

}
