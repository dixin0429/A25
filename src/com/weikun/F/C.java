package com.weikun.F;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/20.
 * 归并排序
 */
public class C {


    private int[] data={50,10,90,30,70,40,80,60,20};
    @Test
    public  void mergeSort(){
        //归并排序
        sort(data , 0 , data.length - 1);


        for( int i:data){
            System.out.println(i);
        }
    }

    /**
     *
     * @param data：排序的数组
     * @param left：左索引
     * @param right：右索引
     */
    private void sort(int[] data, int left, int right) {
        if(left<right){
            int center=(left+right)/2;//相对中间索引
            //切割以center为中间的左边数组
            sort(data,left,center);
            //切割以center为中间的右边数组
            sort(data,center+1,right);

            merge(data,left,center,right);

        }




    }

    /**
     *
     * @param data 排序的数组
     * @param left 左边索引
     * @param center ：中间索引
     * @param right ：右侧索引
     */
    private void merge(int[] data, int left, int center, int right) {
        //声明个临时数组，用于交换数
        int[] tmpArr=new int[data.length];
        int mid=center+1;
        int third=left;//临时数组的种子
        int tmp=left;//真实数组的种子
        //计算 50 和10两个元素，哪个小都先放到临时数组里面
        while(left<=center&&mid<=right){
            if(data[left]-data[mid]<0){
                tmpArr[third++]=data[left++];
            }else{
                tmpArr[third++]=data[mid++];
            }
        }
        //把老数组中的比较后的剩余的那个值放到临时数组中third所指元素的旁边
        while(left<=center){
            tmpArr[third++]=data[left++];
        }
        while(mid<=right){
            tmpArr[third++]=data[mid++];
        }

        //把临时数组中已经拍好的元素付给老数组
        while (tmp<=right){
            data[tmp]=tmpArr[tmp++];
        }





    }
}
