package com.weikun.F;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/20.
 * 插入排序
 */
public class D {

    int[] nums = {9,49,38,10,97,76,13,27,100};
    @Test
    public void test(){
        insertSort(nums);

        for(int i :nums){
            System.out.println(i);
        }
    }
    public void insertSort(int[] source){

        for(int i=0;i<source.length;i++){
            int index=-1;
            for(int j=0;j<i;j++){

                if(source[j]-source[i]>0){
                    index=j;//记住大的索引号，因为要让大的数退一格
                    break;
                }

            }

            //退格
            if(index!=-1){//代表发生source[j]-source[i]>0结果了，把小值取到临时变量中
                int tmp=source[i];
                moveBack(index,i,source);
                source[index]=tmp;
            }
        }


    }
    //退格
    private void moveBack(int index, int i, int[] source) {
        for(int k=i;k>index;k--){
            source[k]=source[k-1];
        }

    }
}
