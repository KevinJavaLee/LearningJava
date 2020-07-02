package com.kevin.day28;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-29-16:32
 */
public class GetTest {


    @Test
    public void test() throws IllegalAccessException, InstantiationException, NoSuchFieldException {

        Class<Human> humanClass = Human.class;
        //创建类的实例
        Human human = humanClass.newInstance();

        //返回指定类型的属性
        Field nation = humanClass.getField("nation");
        //设置指定对象的Field属性
        nation.set(human,"CHN");
        //设置访问的属性
        nation.setAccessible(true);
        Object o = nation.get(human);
        System.out.println(o);

    }

    @Test
    public void test2() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        //反射
        Class<Human> humanClass = Human.class;
        //创建运行时类对象
        Human human = humanClass.newInstance();

        //得到属性值

        Field age = humanClass.getDeclaredField("age");

        //设置指定对象的Field
        age.setAccessible(true);
        //
        age.set(human,12);
        //得到指定对象上的Field属性内容
        Object o = age.get(human);
        System.out.println(o);


    }


    //调用运行时类的指定结构方法
    @Test
    public void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //
        Class<?> aClass = Class.forName("com.kevin.day28.Human");
        //创建运行时类的实例
        Human h = (Human)aClass.newInstance();

        //取得一个Method对象
//        Method show = aClass.getMethod("show", String.class);
//
//        //
//        Object obj = show.invoke(h, "匡总牛逼");
//        System.out.println(obj);
        Method display = aClass.getDeclaredMethod("display", String.class);
        display.setAccessible(true);
        Object invoke = display.invoke(h,"匡总太牛逼");
        System.out.println(invoke);



    }

    @Test
    public void test3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Human human = new Human();
        Class<? extends Human> aClass = human.getClass();
        //获得构造器
    //        Constructor<? extends Human> constructor = aClass.getConstructor();
    //        Human human1 = constructor.newInstance();
    //        System.out.println(human1);
        //获得构造器二
        Constructor<? extends Human> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        Human human2 = declaredConstructor.newInstance("kuangozn",12);
        System.out.println(human2);

    }
}
