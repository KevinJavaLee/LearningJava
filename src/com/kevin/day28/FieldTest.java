package com.kevin.day28;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-29-11:19
 */
public class FieldTest {


    //
    @Test
    public void test() {

        //获取属性
        //获取此类及其父类的所有的public属性
        Class<Human> humanClass = Human.class;
        Field[] fields = humanClass.getFields();
        for (Field field : fields) {
            //1.获取权限修饰符
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
            //2.返回所有的类型
            Class type = field.getType();
            System.out.print(type + "\t");
            //3.获取所有的属性名
            String name = field.getName();
            System.out.print(name + "\t");
            System.out.println();
        }

        System.out.println("-----------------------");
        //得到此类的所有属性
        Field[] declaredFields = humanClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //1.返回权限修饰符
            int modifiers = declaredField.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
            //2.返回属性的类型
            Class<?> type = declaredField.getType();
            System.out.print(type + "\t");

            //3.返回属性的名称
            String name = declaredField.getName();
            System.out.print(name + "\t");
            System.out.println();

        }
    }
}
