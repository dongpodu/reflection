package me.will.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

public class ClassTest extends Foo{
    private String name;
    public String age;


    public static void test() throws Exception {
        Class<ClassTest> clazz = ClassTest.class;
        System.out.println("name:"+clazz.getName()); //me.will.reflection.ClassTest
        System.out.println("simpleName:"+clazz.getSimpleName());//ClassTest
        System.out.println("canonicalName:"+clazz.getCanonicalName());
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

        TypeVariable[] typeVariables = clazz.getTypeParameters();
        Arrays.stream(typeVariables).forEach(r->
                System.out.println("typeVariable:"+r.toString())
        );


    }


    public static void main(String[] args) throws Exception {
        test();
    }
}
