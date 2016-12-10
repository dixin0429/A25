package com.weikun.D;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/8.
 * ����ͼ���ڽӾ����ʾ
 */
public class G {

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

    public  void DFS(){
        boolean [] visited=new boolean[this.mVexs.length];
        for(int i=0;i<this.mVexs.length;i++){
            if(!visited[i]){
                DFS(i,visited);
            }
        }

    }
    public void BFS(){
        int head = 0;//���е�ͷ
        int rear = 0;//���е�β
        int []queue=new int[this.mVexs.length];//��������

        boolean []visited=new boolean[this.mVexs.length];

        for(int i=0;i<this.mVexs.length;i++){

            if(!visited[i]){
                queue[rear++]=i;//���Ѿ������ʵĶ��У���β��
                visited[i]=true;//�Ѿ�������
                System.out.printf("%c",this.mVexs[i]);
            }
            //�³�����ֵ
            while(head!=rear){
                int j=queue[head++];//��������
                int k=firstVertex(j);//�ҵ����һ���ڽӵ�

                while(k>=0){

                    if(!visited[k]){
                        queue[rear++]=k;//���Ѿ������ʵĶ��У���β��
                        visited[k]=true;//�Ѿ�������
                        System.out.printf("%c",this.mVexs[k]);
                    }
                    //iʼ�����ڱ����ң�i���Ǳ������������������£���û���ҵ� k=-1,�����ڲ�ѭ��
                    k=this.nextVertex(j,k);//�¸��ڽӵ�����

                }



            }

        }


    }

    /**
     *
     * @param v:���ҵĶ�������
     * @return ���ص��ǲ��ҵĶ���ĵ�һ���ٽ��������
     */
    private int firstVertex(int v) {

        for(int i=0;i<this.mVexs.length;i++){
            if(this.mMatrix[v][i]==1){
                return i;
            }
        }
        return -1;
    }

    private void DFS(int i, boolean[] visited) {
        visited[i]=true;//����ö����Ѿ����ʹ���
        System.out.printf("%c",this.mVexs[i]);
        //ȥ����i������Ķ����ڽӵĵ�һ���ڵ�
        int j=this.firstVertex(i);//j���ǵ�һ���ڽӵ������

        while(j>=0){
            if(visited[j]==false){
                DFS(j,visited);
            }
            ///��һ�η������нڵ��Ѿ��������ˣ����õ����·���
            //
            j=nextVertex(i,j);//k��������¸��ڽӵ������
        }
    }

    /**
     *
     *
     * @param i :��������
     * @param j������ĵ�һ���ڽӵ������
     * @return ��һ���ڽӵ������
     */
    private int nextVertex(int i, int j) {

        for(int k=j+1;k<this.mVexs.length;k++){
            if(this.mMatrix[i][k]==1){
                return k;
            }
        }
        return -1;//����û���ҵ�
    }

    @Test
    public void test(){
        char[] vexs = {'A', 'B', 'C', 'D','E','F','G','H','I'};
        char[][] edges = new char[][]{//���Ǹ���ά����
                {'A', 'B'},
                {'A', 'F'},
                {'B', 'G'},
                {'B', 'C'},
                {'B', 'I'},
                {'B', 'A'},
                {'C', 'B'},
                {'C', 'I'},
                {'C', 'D'},
                {'D', 'C'},
                {'D', 'I'},
                {'D', 'G'},
                {'D', 'H'},
                {'D', 'E'},
                {'E', 'H'},
                {'E', 'F'},
                {'E', 'D'},
                {'F', 'G'},
                {'F', 'A'},
                {'F', 'E'},
                {'G', 'H'},
                {'G', 'D'},
                {'G', 'B'},
                {'G', 'F'},
                {'H', 'G'},
                {'H', 'D'},
                {'H', 'E'},
                {'I', 'B'},
                {'I', 'C'},
                {'I', 'D'}

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

        DFS();
        System.out.println();
        BFS();

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
