package com.weikun.F;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/20.
 * ��������
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
                    index=j;//��ס��������ţ���ΪҪ�ô������һ��
                    break;
                }

            }

            //�˸�
            if(index!=-1){//������source[j]-source[i]>0����ˣ���Сֵȡ����ʱ������
                int tmp=source[i];
                moveBack(index,i,source);
                source[index]=tmp;
            }
        }


    }
    //�˸�
    private void moveBack(int index, int i, int[] source) {
        for(int k=i;k>index;k--){
            source[k]=source[k-1];
        }

    }
}
