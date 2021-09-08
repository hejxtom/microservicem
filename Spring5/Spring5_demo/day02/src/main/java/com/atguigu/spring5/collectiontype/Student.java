package com.atguigu.spring5.collectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Classname Student
 * @Description TODO
 * @Date 21:35 2021/3/16
 * @Created by hejx
 */

public class Student {
    //1.数组类型的属性
    private String[] courses;

    //list集合的属性
    private List<String> list;

    //map集合的属性
    private Map<String,String> map;

    //set集合属性
    private  Set<String> sets;

    //学生所学的多门课程
    private List<Couse> courseList;

    public void setCourseList(List<Couse> courseList) {
        this.courseList = courseList;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }


    @Override
    public String toString() {
        return "Student{" +
                "courses=" + Arrays.toString(courses) +
                ", list=" + list +
                ", map=" + map +
                ", sets=" + sets +
                ", courseList=" + courseList +
                '}';
    }
}
