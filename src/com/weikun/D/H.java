package com.weikun.D;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/10.
 * Prim����С������
 */
public class H {
    private static final int INF = Integer.MAX_VALUE;

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

        prim(0);


    }

    /**
     *
     * @param: ��0�Ŷ��㿪ʼ���㷨
     */

    private void prim(int start) {

        int len=this.mVexs.length;
        char [] result=new char[len];//����������
        int weights[]=new int[len];//Ȩֵ����

        int index=0;

        //��start���ڶ���ŵ����������
        result[index++]=this.mVexs[start];
        for(int i=0;i<len;i++){
            weights[i]=this.mMatrix[start][i];
        }
        //��ʼ��Ȩֵ��С�ĵ�
        for(int i=0;i<len;i++){

            if(start==i){//AA��û������,�Լ����Լ��ĵ�
                continue;
            }
            int k=0;//ͬ���µ���СȨֵ�е�����
            int j=0;
            int min=INF;

            while(j<len){//����ͬһ���µ������У���˭��Ȩֵ��С���������ŵ�k��

                if(weights[j]!=0&&weights[j]<min){

                    min=weights[j];
                    k=j;
                }
                j++;

            }
            //�����
            result[index++]=this.mVexs[k];
            //����k���Ѿ����£�������Ȩֵ�����а�����ȨֵĨȥ
            weights[k]=0;

            //�����Ѿ��ҵ�����С����k�����¸�����k��Ϊ�������Ȩֵ
            //��Ϊweights��һά���飬һ��ֻ�ܴ洢��СȨֵ��������������Ǹ�����ָ���Ǹ�һ�е�����Ȩֵ��

            for(j=0;j<len;j++){
                if(weights[j]!=0&&this.mMatrix[k][j]<weights[j]){
                    weights[j]=this.mMatrix[k][j];

                }
            }

        }

        //������С��������Ȩֵ
        //i==1����B��A�㲻��Ҫ����
        int sum=0;
        for(int i=1;i<index;i++){


            int k=this.getPosition(result[i]);//����㣬�ڶ��㼯�ϵ�����//B
            //�ҵ�k�����ڵĶ��㣬�����������
            int min=INF;
            for(int j=0;j<i;j++){

                int n=this.getPosition(result[j]);//A

                if(this.mMatrix[n][k]<min){//����ȷʵС
                    min=this.mMatrix[n][k];
                }

            }
            sum+=min;
        }
        System.out.println(sum);


        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);

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
