package com.sangeng.utils;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shkstart
 * @create 2023--03-9:10
 */
public class BeanCopyUtils {
    private BeanCopyUtils(){
    }

    public  static <T> T copyBean(Object object,Class<T> clazz) {
        T result=null;
        try {
            result= clazz.newInstance();
            BeanUtils.copyProperties(object, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <T,V> List<T> copyBeanList(List<V> list,Class<T> clazz){
        return list.stream().map(o -> copyBean(o, clazz)).collect(Collectors.toList());
    }

}
