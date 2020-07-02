package com.kevin.day13;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-13-11:21
 */

interface Product{
    public String getName();

    public double getPprice();
}


public class Anonymous {

    public void test(Product product) {
        System.out.println("购买了一个商品："+product.getName()+"价格为："+product.getPprice());
    }
    public static void main(String[] args) {
        /**/
        Anonymous anonymous = new Anonymous();
        /*匿名内部类的使用*/
        anonymous.test(new Product() {
            @Override
            public String getName() {
                return "冰棍";
            }

            @Override
            public double getPprice() {
                return 3.5;
            }
        });
    }

}
