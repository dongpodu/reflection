package me.will.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

public class ParameterizedTypeTest {
    // 下面的 field 的 Type 属于 ParameterizedType
    private Map<String,?> data;

    // 下面的 field 的 Type 不属于ParameterizedType
    private String str;
    private Integer i;
    private Set set;

    public void test() throws NoSuchFieldException {
        Class<ParameterizedTypeTest> clazz = ParameterizedTypeTest.class;
        Field field = clazz.getDeclaredField("data");
        Type type = field.getGenericType();
        if (type instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType)type;
            Type[] types = parameterizedType.getActualTypeArguments();
            for(Type ty:types){
                System.out.println("parameterizedType:"+ty.getTypeName());
            }
            Type ownerType = parameterizedType.getOwnerType();
            System.out.println("ownerType:"+(ownerType==null?null:ownerType.getTypeName()));
            Type rawType= parameterizedType.getRawType();
            System.out.println("rawType:"+(rawType==null?null:rawType.getTypeName()));
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {
        new ParameterizedTypeTest().test();
    }

}
