package com.kevin.day22;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-16-17:39
 */


public class Season {


    private final String seasonName ;
    private final String seasonDesc;

    Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    private final Season SPRING = new Season("春天", "春意盎然");
    private final Season SUMMER = new Season("夏天", "烈日当空");
    private final Season AUTUMN = new Season("秋天", "秋高气爽");
    private final Season WINTER = new Season("冬天", "寒风");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    public static void main(String[] args) {


    }
}
