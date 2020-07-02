package com.kevin.day22;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-16-17:52
 */
public enum Season1 {

    SPRING,SUMMER,AUTUMN,WINTER;

}

class SeasonTest {
    public static void main(String[] args) {
        //enum类常用的方法
        //返回枚举类型的对象数组
        //values()f
        Season1[] values = Season1.values();
        for (Season1 value : values) {
            System.out.println(value);
        }
        //把一个字符串转换为对应的枚举类对象
        System.out.println(Season1.valueOf("SPRING"));

        //返回当前枚举类对象常量的名字
        System.out.println(Season1.WINTER.toString());


    }
}
