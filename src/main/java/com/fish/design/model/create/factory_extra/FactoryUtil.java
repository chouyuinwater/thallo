package com.fish.design.model.create.factory_extra;

/**
 * 对象生成器
 */
public class FactoryUtil {

    /**
     * 根据配置文件的配置利用反射生成对象
     * @return 生成的对象
     */
    public static Object getBean() {
        Object result = null;
        // 该变量可以由配置文件取的，此处省略
        String className = "model.create.factory_extra.impl.CapcomFactory";
        try {
            Class aClass = Class.forName(className);
            result = aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return result;
    }
}
