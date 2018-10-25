package me.will.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericMethodTest {

    public void setStringList(List<String> list,String str){
        System.out.println("setStringList");
    }

    public void test() throws  NoSuchMethodException {
        Class<GenericMethodTest> clazz = GenericMethodTest.class;
        Method method = clazz.getMethod("setStringList",List.class,String.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes(); //返回方法的形式参数类型

        for(Type genericParameterType : genericParameterTypes){
            if(genericParameterType instanceof ParameterizedType){
                ParameterizedType aType = (ParameterizedType) genericParameterType;
                Type[] parameterArgTypes = aType.getActualTypeArguments();
                for(Type parameterArgType : parameterArgTypes){
                    Class parameterArgClass = (Class) parameterArgType;
                    System.out.println("parameterArgClass = " + parameterArgClass);
                }
            }
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        new GenericMethodTest().test();
    }
}
