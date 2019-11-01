package com.fish.design.util;


import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * user:hudawei1
 * date:2018/7/26
 * time:16:42
 */
public class CopyUtils {


    public static <T>T copyProperties(Object source,Class<T> target){
        T result = null;
        try {
            result = target.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BeanUtils.copyProperties(source,result);
        return result;
    }

    /**
     * list copy，返回指定类型的list
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    public static <T>List<T> copyListProperties(List<?> source, Class<T> target){
        if(source == null || source.size()==0){
            return null;
        }
        List<T> resultList = new ArrayList<>();
        for(Object obj : source){
            resultList.add(copyProperties(obj,target));
        }
        return resultList;
    }

//    public static void main(String[] args){
//        List list1 = new ArrayList();
//        P1 a = new P1();
//        a.setName("aaa");
//        P1 b = new P1();
//        b.setName("bbb");
//        list1.add(a);
//        list1.add(b);
//        List list2 = copyListProperties(list1,P2.class);
//        System.out.print(list2);
//    }
}
