package com.kevin.day29;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-30-11:00
 */

@FunctionalInterface
public interface MyNumber<T> {
    public T getValue(T t);
}
