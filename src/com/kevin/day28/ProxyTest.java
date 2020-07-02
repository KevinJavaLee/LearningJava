package com.kevin.day28;

import sun.security.util.AuthResources_it;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-29-20:22
 */

//
interface ClothFactory{
    public void produceCloth();
}

//代理类
class ProxyFactory implements ClothFactory {
    //
    ClothFactory clothFactory ;

    ProxyFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        //代工厂作生产前的准备
        System.out.println("代工厂作生产前的准备！");

        clothFactory.produceCloth();

        System.out.println("生产衣服完成！");
    }
}

class ANTAFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("匡总正在皮鞋厂生产皮鞋！");
    }
}






public class ProxyTest {
    public static void main(String[] args) {
        //1.创建被代理类对象
        ANTAFactory antaFactory = new ANTAFactory();
        //2.创建代理类对象
        ProxyFactory proxyFactory = new ProxyFactory(antaFactory);
        //3.
        proxyFactory.produceCloth();

    }
}
