package com.weikun.A;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 2016/12/4.
 * 迪杰斯特拉双栈算法，计算表达式
 */
public class D {
    @Test
    public void test(){
        Stack<Integer> vals = new Stack<Integer>();//数栈
        Stack<Character> op = new Stack<Character>();//运算符栈

        String s="((1+((2+3)+(2*4)))*2)";

        char [] cs=s.toCharArray();

        for(int i=0;i<cs.length;i++){

            if(cs[i]=='+'){//push操作符
                op.push(cs[i]);

            }else if(cs[i]=='-'){//push操作符
                op.push(cs[i]);
            }else if(cs[i]=='*'){//push操作符
                op.push(cs[i]);
            }else if(cs[i]=='/'){//push操作符
                op.push(cs[i]);
            }else if(cs[i]=='('){//不动

            }else if(cs[i]==')'){
                Integer v=vals.pop();//操作数弹出
                char c=op.pop();//操作符弹出
                if(c=='+'){
                    v=v+vals.pop();
                }else if(c=='*'){
                    v=v*vals.pop();
                }else if(c=='-'){
                    v=vals.pop()-v;
                }else if(c=='/'){
                    v=vals.pop()/v;
                }
                vals.push(v);

            }else{//进入运算数
                vals.push(Integer.parseInt(cs[i]+""));

            }

        }

        System.out.print(vals.peek());
    }


}
