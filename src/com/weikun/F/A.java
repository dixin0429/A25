package com.weikun.F;

/**
 * Created by Administrator on 2016/12/20.
 * —°‘Ò≈≈–Ú
 */
public class A {
    public static void main(String[] args) {
        int a[]={3,1,4,7,5,9,10};
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                int tmp=0;
                if(a[i]>a[j]){
                    tmp=a[i];
                    a[i]=a[j];
                    a[j]=tmp;
                }

            }
        }
        for(int i :a){
            System.out.println(i);
        }

    }
}
