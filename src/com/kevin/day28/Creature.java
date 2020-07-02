package com.kevin.day28;

import java.io.Serializable;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-28-21:30
 */
public class Creature   {

    private char sex;
    public double weight;

    public Creature() {

    }

    public Creature(char sex, double weight) {
        this.sex = sex;
        this.weight = weight;
    }
    public void breath(double weight) {
        System.out.println("生物要呼吸！");
    }

    public void eat() {
        System.out.println("生物要吃东西");
    }



}
