package me.will.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassTest extends Foo{
    private String name;
    public String age;


    public static void test() throws Exception {
        Class<ClassTest> clazz = ClassTest.class;
        System.out.println(clazz.getName()); //me.will.reflection.ClassTest
        System.out.println(clazz.getSimpleName());//ClassTest
        System.out.println(clazz.getModifiers());//1
        System.out.println(Modifier.isPublic(clazz.getModifiers()));//true

        Package pack = clazz.getPackage();
        System.out.println(pack.getName());//me.will.reflection
        System.out.println(pack.getSpecificationVersion());//保存在Manifest 文件中


        Class[] interfaces = clazz.getInterfaces();
        Arrays.stream(interfaces).forEach(r->
                System.out.println("interface"+r.getSimpleName())
        );

        Class superclass = clazz.getSuperclass();
        System.out.println("super:"+superclass.getSimpleName());

        Constructor[] constructors = clazz.getConstructors();
        Arrays.stream(constructors).forEach(r->
                System.out.println("constructor:"+r.getName())
        );

        Field[] fields = clazz.getFields();// only return this class and superclass's public fields
        Arrays.stream(fields).forEach(r->
                System.out.println("field:"+r.getName())
        );

        Method[] methods = clazz.getMethods();
        Arrays.stream(methods).forEach(r->
                System.out.println("method:"+r.getName())
        );

        Annotation[] annotations = clazz.getAnnotations();
        Arrays.stream(annotations).forEach(r->
                System.out.println("annotation:"+r.toString())
        );
    }


    public static void main(String[] args) throws Exception {
        test();
    }
}
