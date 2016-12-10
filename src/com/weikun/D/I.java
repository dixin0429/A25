package com.weikun.D;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/10.
 * ��³˹��������С������
 */
public class I {
    private static final int INF = Integer.MAX_VALUE;
    private int ecount;        // �ߵ�����edge count
    private char[] mVexs;       // ���㼯��
    private int[][] mMatrix;    // �ڽӾ���
    @Test
    public void test(){

        //����
        char[] tops = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //INF���ֵ,Ҳ�������ڽӾ����У����������û�бߣ��ͱ�����ֵ
        //0 ���Լ����Լ��ĵ�ı��

        int matrix1[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
         /*A*/ {   0,  12, INF, INF, INF,  16,  14},
         /*B*/ {  12,   0,  10, INF, INF,   7, INF},
         /*C*/ { INF,  10,   0,   3,   5,   6, INF},
         /*D*/ { INF, INF,   3,   0,   4, INF, INF},
         /*E*/ { INF, INF,   5,   4,   0,   2,   8},
         /*F*/ {  16,   7,   6, INF,   2,   0,   9},
         /*G*/ {  14, INF, INF, INF,   8,   9,   0}
        };
        this.mVexs=tops;
        this.mMatrix=new int[tops.length][tops.length];
        for(int i=0;i<this.mVexs.length;i++){
            for(int j=0;j<this.mVexs.length;j++){
                this.mMatrix[i][j]=matrix1[i][j];
            }

        }
        //ͳ�ƺϷ��ߵ������������Լ����Լ�������û�����ӵı�

        for(int i=0;i<this.mVexs.length;i++){
            for(int j=i+1;j<this.mVexs.length;j++){
                if(this.mMatrix[i][j]!=INF){

                    this.ecount++;
                }

            }

        }
        this.krusker();



    }

    // �ߵĽṹ��
    private static class EData {
        char start; // �ߵ����
        char end;   // �ߵ��յ�
        int weight; // �ߵ�Ȩ��

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    };

    public void krusker(){
        int index=0;
        //������Ч�ر߼���
        EData [] res=new EData[this.ecount];
        //����������
        int result[]=new int[this.mVexs.length];

        EData [] data=this.getEdges();
        //�����Ԫ��
        sortEdges(data,this.ecount);

        for(int i=0;i<this.ecount;i++){
            int start =this.getPosition(data[i].start);
            int end =this.getPosition(data[i].end);
            //start�����ӵ�ĩβ��
            int s1=this.getEnd(result,start);
            //end�����ӵ�ĩβ��
            int e1=this.getEnd(result,end);
            if(s1!=e1){//ȷʵû���γɻ�·

                result[s1]=e1;//���s1��Ϊ��� e1��Ϊ�յ�

                res[index++]=data[i];//������û���γɻ�·����Ч��
            }

        }


        // ͳ�Ʋ���ӡ"kruskal��С������"����Ϣ
        int length = 0;
        for (int i = 0; i < index; i++){
            length += res[i].weight;
        }
        System.out.printf("Kruskal=%d: ", length);
        for (int i = 0; i < index; i++){
            System.out.printf("(%c,%c) ", res[i].start, res[i].end);
        }




    }

    /**
     * �ж�
     * @param  ��������㼯��
     * @param i :��������
     * @return���ڽ���к��������ļ��ϵ�λ��
     */
    private int getEnd(int[] result, int i) {
        while(result[i]!=0){//����i���ڵ�ĩβ�����

            i=result[i];
        }
        return i;

    }

    /**
     *
     * @return //ͳ�Ʊ߶�������
     */
    public  EData [] getEdges(){
        EData [] data=new EData[this.ecount];
        int index=0;
        for(int i=0;i<this.mVexs.length;i++){
            for(int j=i+1;j<this.mVexs.length;j++){
                if(this.mMatrix[i][j]!=INF){
                    data[index++]=new EData(this.mVexs[i],this.mVexs[j],this.mMatrix[i][j]);;
                }
            }

        }

        return data;
    }

    /**
     *
     * @param edges:��Ч�ߵļ���
     * @param elen:����Ч�ߵĵ�����
     */

    private void sortEdges(EData[] edges, int elen) {

        for(int i=0;i<elen;i++){
            for(int j=i+1;j<elen;j++){
                EData temp=null;
                if(edges[i].weight>edges[j].weight){
                    temp=edges[j];
                    edges[j]=edges[i];
                    edges[i]=temp;
                }
            }
        }
    }
    public int getPosition(char c){//�ҵ����ڶ��㼯�ϵ�λ��
        for(int i=0;i<this.mVexs.length;i++){
            if(this.mVexs[i]==c){
                return i;
            }
        }
        return -1;

    }
}

