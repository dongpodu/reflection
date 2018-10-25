package me.will.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericFieldTest {
    public List<String> stringList;

    public void test() throws NoSuchFieldException {
        Class<GenericFieldTest> clazz = GenericFieldTest.class;
        Field field = clazz.getField("stringList");

        Type genericFieldType = field.getGenericType();

        if(genericFieldType instanceof ParameterizedType){
            ParameterizedType aType = (ParameterizedType) genericFieldType;
            Type[] fieldArgTypes = aType.getActualTypeArguments();
            for(Type fieldArgType : fieldArgTypes){
                Class fieldArgClass = (Class) fieldArgType;
                System.out.println("fieldArgClass = " + fieldArgClass);
            }
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {
        new GenericFieldTest().test();
    }
}
