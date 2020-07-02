package com.kevin.day13;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-12-16:09
 */
public class FatherDemo {

    public void method1() {
        System.out.println("晓宇牛逼！");
    }
}


//当接口中的方法和父类中的方法相同时，类中的方法优先
class  SonDemo extends FatherDemo implements InterfaceTest{
    public static void main(String[] args) {
        SonDemo sonDemo =  new SonDemo();
        //调用静态方法
        InterfaceTest.method();
        //重写mehod1()方法
        sonDemo.method1();
        //重写method(）2方法
        sonDemo.method2();
    }
}