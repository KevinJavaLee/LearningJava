package com.kevin.day13;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-12-20:24
 */
public class Ourter {
    public static void main(String[] args) {
        Ourter ourter = new Ourter();
        Ourter.Inner inner = ourter.new Inner();
//        ourter.ma();
        //调用内部类中的方法
        inner.mb(333);
    }

    private int s=100;
    //非静态成员内部类
    public class Inner{
        private int s = 200;
        public void mb(int s) {

            System.out.println("在内部类Inner中的s="+s);
            System.out.println("内部类对象的属性s="+this.s);
            System.out.println("外部类对象属性s="+Ourter.this.s);
        }
    }

//    public void ma() {
//        System.out.println("----------------------------");
//        Inner i = new Inner();
//        i.mb();
//        System.out.println("----------------------------");
//    }

}
