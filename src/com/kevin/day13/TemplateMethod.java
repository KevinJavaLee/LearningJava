package com.kevin.day13;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-12-15:38
 */


abstract class TemplateMethod {
    public void spendTime() {
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public abstract void code();
}

class TemplateTest extends TemplateMethod{
    public static void main(String[] args) {
        TemplateMethod templateMethod = new TemplateTest();
        templateMethod.spendTime();
    }

    @Override
    public void code() {

        //输出10000 之内的所有质数
        for (int i = 2; i < 10000; i++) {
            boolean isFlag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {

                if (i % j == 0) {
                    isFlag = false;
                    break;
                }

            }
            if (isFlag) {
                System.out.println(i);
            }

        }
    }
}
