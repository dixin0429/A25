package com.weikun.D;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/8.
 * ����ͼ���ڽӾ����ʾ
 */
public class B {

    private char[] mVexs;       // ���㼯��
    private int[][] mMatrix;    // �ڽӾ���

    //��������ͼ
    public void make(char[] mvexs,int [][] mmatrix){
        //��ʼ������
        this.mVexs=mvexs;
        //��ʼ����


    }

    /**
     *
     * @param c Ҫ���ҵĶ���
     * @return �ڶ��������е�������
     */
    public int getPosition(char c){

        for(int i=0;i<this.mVexs.length;i++){
            if(this.mVexs[i]==c){
                return i;
            }

        }
        return -1;

    }
    @Test
    public void test(){
        char[] vexs = {'A', 'B', 'C', 'D'};
        //����ͼ��,����ͼ������ͼ����һ�£�ֻ��������ͼAB�������㣬�߱�ʾ��A->B B->A
        char[][] edges = new char[][]{//���Ǹ���ά����
                {'A', 'B'},
                {'B', 'C'},
                {'C', 'D'},
                {'A', 'D'},
                {'A', 'C'}
        };

        this.mVexs=vexs;
        //��ά������������ÿ�����������
        this.mMatrix=new int[this.mVexs.length][this.mVexs.length];
        for(int i=0;i<edges.length;i++){//�������㼯���ˣ���������������ɻ�����ɻ���ֵ����1
            int pos1=this.getPosition(edges[i][0]);
            int pos2=this.getPosition(edges[i][1]);

            this.mMatrix[pos1][pos2]=1;
        }
        this.print();



    }
    public void print(){

        for(int i=0;i<this.mVexs.length;i++){
            for(int j=0;j<this.mVexs.length;j++){

                System.out.printf("%d ",this.mMatrix[i][j]);

            }
            System.out.println();

        }
    }
}