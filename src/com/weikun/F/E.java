package com.weikun.F;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/24.\
 * shell����
 */
public class E {
    public static int count = 0;
    private int [] data={47,55,10,40,15,94,5,70,2,3,4,17,90,88};
    public static void main(String[] args) {

    }
    @Test
    public void shellSort(){
        //1����������ʵļ��ֵ��h��ʹ�ù�ʽ����
        int arrayLength=data.length;

        int h=0;
        while(h<=arrayLength/3){
            h=h*3+1;
        }
        //h=1�����������������в�ֵ����,
        // h=4:һ��һ�ν��в�ֵ����

        //����֮�󣬵�ǰ����������8��Ԫ�أ��������h����4


        //1�������ŵ�Ԫ�ط��飬�������ڴ�Լ����С����ǰ�棬����ں���
        while(h>0){

            for(int i=h;i<arrayLength;i++){//i=4, 5 6 7

                int tmp=data[i];//��Сֵ�ŵ���ʱ������
                if(data[i-h]-data[i]>0){//֤��data[0]>data[4]

                    int j=i-h;
                    //��h����
                    for(  ;j>=0&& data[j]-tmp>0; ){
                        // data[j]-tmp>0������ʱ���������Ҫ��֮ǰ
                        // ������Ԫ�ؽ��бȶԣ�
                        // ���ǽ������Աߵıȶԣ����С�ģ��ٴ�ʹ�ò�ֵ��
                        data[j+h]=data[j];
                        j=j-h;
                    }
                    data[j+h]=tmp;
                }

            }

            h=(h-1)/3;//��h��Ϊ��һ�����ֵ��Ӧ����1
        }

        for(int i :data){
            System.out.println(i);
        }

    }
}
