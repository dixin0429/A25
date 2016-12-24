package com.weikun.F;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/24.\
 * shell排序
 */
public class E {
    public static int count = 0;
    private int [] data={47,55,10,40,15,94,5,70,2,3,4,17,90,88};
    public static void main(String[] args) {

    }
    @Test
    public void shellSort(){
        //1。计算最合适的间隔值，h，使用公式计算
        int arrayLength=data.length;

        int h=0;
        while(h<=arrayLength/3){
            h=h*3+1;
        }
        //h=1：相邻两个两两进行插值排序,
        // h=4:一段一段进行插值排序

        //计算之后，当前数组由于是8个元素，它的最佳h就是4


        //1：计算大概的元素分组，让他组内大约排序，小的在前面，大的在后面
        while(h>0){

            for(int i=h;i<arrayLength;i++){//i=4, 5 6 7

                int tmp=data[i];//把小值放到临时变量中
                if(data[i-h]-data[i]>0){//证明data[0]>data[4]

                    int j=i-h;
                    //退h个格
                    for(  ;j>=0&& data[j]-tmp>0; ){
                        // data[j]-tmp>0代表临时的这个变量要和之前
                        // 的所有元素进行比对，
                        // 不是仅仅和旁边的比对，如果小的，再次使用插值法
                        data[j+h]=data[j];
                        j=j-h;
                    }
                    data[j+h]=tmp;
                }

            }

            h=(h-1)/3;//让h称为下一个间隔值，应该是1
        }

        for(int i :data){
            System.out.println(i);
        }

    }
}
