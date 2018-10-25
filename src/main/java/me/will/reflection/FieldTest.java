package me.will.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

public class FieldTest extends Foo{
    private String name;
    public String age;


    public static void test() throws Exception {
        Class<FieldTest> clazz = FieldTest.class;
        Field[] fields = clazz.getFields();// 返回本类和父类的public属性
        Arrays.stream(fields).forEach(r->
                System.out.println("field:"+r.getName())
        );
    }

    public static void test1() throws Exception {
        Class<FieldTest> clazz = FieldTest.class;
        Field[] fields = clazz.getDeclaredFields();// 返回本类属性，如果在别的类中调用该方法，则private属性不返回
        Arrays.stream(fields).forEach(r->
                System.out.println("field:"+r.getName())
        );
    }


    public static void main(String[] args) throws Exception {
        test();
        System.out.println("------------------------------");
        test1();
    }
}
