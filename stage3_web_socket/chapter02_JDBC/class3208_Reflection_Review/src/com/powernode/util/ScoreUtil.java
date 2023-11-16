package com.powernode.util;

import java.lang.reflect.Field;

public class ScoreUtil {
    public static void set(Object o, String what, Object Substance) throws Exception {
        Class<?> oClass = o.getClass();
        Field declaredField = oClass.getDeclaredField(what);
        declaredField.setAccessible(true);
        declaredField.set(o, Substance);
    }

    public static Object get(Object o, String what) throws Exception {
        Class<?> aClass = o.getClass();
        Field declaredField = aClass.getDeclaredField(what);
        declaredField.setAccessible(true);
        Object o1 = declaredField.get(o);
        return o1;
    }
}
