package com.kevin.day13;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-12-9:27
 */


/*懒汉式
*优点：延迟加载
*缺点：线程不安全
* */
public class SingletonTest1 {


    public static void main(String[] args) {
        Order order = Order.getOrderInstance();
        Order order1 = Order.getOrderInstance();

        System.out.println(order == order1);
    }
}

class Order{

    /*构造方法为私有 只能在内部创建对象*/
    private Order() {

    }

    private  static Order order = null;

    public static Order getOrderInstance() {
        if (order == null) {
            order = new Order();
        }
        return order;
    }
}
