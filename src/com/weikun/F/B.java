package com.weikun.F;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/20.
 * ������
 */
public class B {
    private int [] data={9,79,46,30,58,49};
    public static void main(String[] args) {

    }
    @Test
    public  void heapSort() {

        System.out.println("��ʼ����");
        int arrayLength = data.length;
        //ѭ�����ѣ�������ȫ������
		/*
		 *        9
		 *      /   \
		 *    79    46
		 *   / \   /
		 * 30  58 49
		 */
        //�����ȫ���������󶥶ѣ���˵�ֵ(0������)�϶�����û����֮ǰ������ֵ��
        //��������������������򽻻����������������棬��Ȼ�����������棬�������������ݲ�û���źã���ˣ���Ҫ��ͣ�������㣬���½��ѣ���Ҫѭ��


        for(int i=0;i<arrayLength-1;i++){

            builMaxdHeap(arrayLength-1-i);


            swap( 0 , arrayLength - 1 - i);
        }


        for( int i:data){
            System.out.println(i);

        }
    }
    //�����󶥶�
    public void builMaxdHeap(int lastIndex){
        //(lastIndex-1)/2 �ҵ�lastIndex�ĸ��ڵ��������
        for(int i=(lastIndex-1)/2 ; i>=0;i-- ){//
            int k=i;
            //�жϵ�ǰforѭ��ָ���Ľڵ���ӽڵ�
            while(k*2+1<=lastIndex){

                //������ӽ������

                int bigIndex=k*2+1;//
                //�ж��Ƿ������ӽڵ㣬Ҳ���ǿ��������ӽڵ�������Ƿ����
                if(bigIndex<lastIndex){
                    if(data[bigIndex]-data[bigIndex+1]<0){
                        bigIndex++;
                    }

                }
                //����leftIndex�����Ǹ���ֵ������������ţ��ٺ͸��ױ�
                if(data[k]-data[bigIndex]<0){//���ӱȸ��״�,Ҫ����
                    swap(k,bigIndex);
                }else{

                    break;
                }


            }


        }
    }
        //�����������������
    private void swap(int k, int bigIndex) {

        int tmp=0;
        tmp=data[k];
        data[k]=data[bigIndex];
        data[bigIndex]=tmp;


    }
}
