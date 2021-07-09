package lz.helper;

import lz.utils.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class BeanHelper {

    /**
     * BEAN_MAP相当于一个Spring容器, 拥有应用所有bean的实例
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();
    private static final Map<Class<?>, Object> Proxy_MAP = new HashMap<Class<?>, Object>();


    static {
        //获取应用中的所有bean
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        System.out.println("BeanHelper中beanClassSet.size()" + "**********" + beanClassSet.size());
        //将bean实例化, 并放入bean容器中
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            System.out.println(obj);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    /**
     * 获取 Bean 容器
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取 Bean 实例
     */

    public static <T> T getBean(Class<T> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not get lz.bean by class: " + cls);
        }
        return (T) BEAN_MAP.get(cls);
    }

    /**
     * 设置 Bean 实例
     */
    public static void setBean(Class<?> cls, Object obj) {
        BEAN_MAP.put(cls, obj);
    }


    /**
     * 获取 Bean 容器
     */
    public static Map<Class<?>, Object> getBeanMap_proxy() {
        return Proxy_MAP;
    }

    /**
     * 获取 Bean 实例
     */

    public static <T> T getBean_proxy(Class<T> cls) {
        if (!Proxy_MAP.containsKey(cls)) {
            throw new RuntimeException("can not get lz.bean by class: " + cls);
        }
        return (T) Proxy_MAP.get(cls);
    }

    /**
     * 设置 Bean 实例
     */
    public static void setBean_proxy(Class<?> cls, Object obj) {
        Proxy_MAP.put(cls, obj);
    }

}
