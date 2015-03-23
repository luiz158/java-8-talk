package pl.mszarlinski.talks.cp.excersise.java7;

import java.lang.reflect.Field;

/**
 * Created by Maciej on 2015-03-18.
 */
public class ReflectionUtil {

    public void setField(Object target, String fieldName, Object value) {
        try {
            Field f = target.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            f.set(target, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
