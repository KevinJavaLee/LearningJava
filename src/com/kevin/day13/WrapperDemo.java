package com.kevin.day13;

import java.util.Scanner;
import java.util.Vector;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-11-9:57
 */
public class WrapperDemo {
    public static void main(String[] args) {

        //1.输出数据
        Scanner input = new Scanner(System.in);

        int num = 0;
        int maxScore = 0;
        Vector vector = new Vector();
        while (true) {
            num = input.nextInt();
            System.out.println(num);
            if (num < 0) {
                break;
            }else{
                //找出最大的数
                if (maxScore < num) {
                    maxScore = num;
                }
                //2.把数字放入vector容器终去
                vector.addElement(num);
            }

        }
        Object obj;
        int diffrence = 0;
        //取出容器中各个元素
        for (int i = 0; i < vector.size() ; i++) {
            //获取容器中的元素
            obj = vector.elementAt(i);
            //将获取的数转换为整数进行比较
            diffrence = maxScore - (int)obj;
            if (diffrence <= 10) {
                System.out.println("A");
            } else if (diffrence <= 20) {
                System.out.println("B");
            } else if (diffrence <= 30) {
                System.out.println("C");
            }else{
                System.out.println("D");
            }
        }
    }
}


