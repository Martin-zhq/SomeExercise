package cn.xxt.designpattern.filterpattern;

public class Student {

    private int age;

    private String name;

    private String major;

    public Student() {

    }

    public Student(int age, String name, String major) {
        this.age = age;
        this.name = name;
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "student name:" + name + ", age:" + age + ", major:" + major;
    }
}
