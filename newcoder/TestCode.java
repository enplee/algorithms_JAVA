package enplee.algorithms_JAVA.newcoder;

import java.util.Arrays;

public class TestCode {
    public static void main(String[] args) throws InterruptedException {
        Parent p = new Parent("guanyu");
        Parent p1 = new Parent("dsdfs");
        p.show();
        p1.show();
    }
}
class Parent{
    public static String name;

    public Parent(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println(name);
    }
}

