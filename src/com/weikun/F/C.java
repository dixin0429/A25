package com.weikun.F;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/20.
 * �鲢����
 */
public class C {


    private int[] data={50,10,90,30,70,40,80,60,20};
    @Test
    public  void mergeSort(){
        //�鲢����
        sort(data , 0 , data.length - 1);


        for( int i:data){
            System.out.println(i);
        }
    }

    /**
     *
     * @param data�����������
     * @param left��������
     * @param right��������
     */
    private void sort(int[] data, int left, int right) {
        if(left<right){
            int center=(left+right)/2;//����м�����
            //�и���centerΪ�м���������
            sort(data,left,center);
            //�и���centerΪ�м���ұ�����
            sort(data,center+1,right);

            merge(data,left,center,right);

        }




    }

    /**
     *
     * @param data ���������
     * @param left �������
     * @param center ���м�����
     * @param right ���Ҳ�����
     */
    private void merge(int[] data, int left, int center, int right) {
        //��������ʱ���飬���ڽ�����
        int[] tmpArr=new int[data.length];
        int mid=center+1;
        int third=left;//��ʱ���������
        int tmp=left;//��ʵ���������
        //���� 50 ��10����Ԫ�أ��ĸ�С���ȷŵ���ʱ��������
        while(left<=center&&mid<=right){
            if(data[left]-data[mid]<0){
                tmpArr[third++]=data[left++];
            }else{
                tmpArr[third++]=data[mid++];
            }
        }
        //���������еıȽϺ��ʣ����Ǹ�ֵ�ŵ���ʱ������third��ָԪ�ص��Ա�
        while(left<=center){
            tmpArr[third++]=data[left++];
        }
        while(mid<=right){
            tmpArr[third++]=data[mid++];
        }

        //����ʱ�������Ѿ��ĺõ�Ԫ�ظ���������
        while (tmp<=right){
            data[tmp]=tmpArr[tmp++];
        }





    }
}
