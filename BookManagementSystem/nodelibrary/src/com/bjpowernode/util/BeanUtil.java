package com.bjpowernode.util;

import java.io.ObjectInputStream;
import java.lang.reflect.Field;

public class BeanUtil {
    /**
     * ����������ֵ����
     * @param origin
     * @param dest
     */
    public static void populate(Object origin,Object dest){
        //ʹ�÷������������
        try {
            //�ж����������Ƿ���ͬһ������
            if(origin.getClass()!=dest.getClass()){
                throw new RuntimeException("��������������ͬһ�����͡�");
            }
            Class<?> clazz=origin.getClass();
            //��ȡorigin�е�����
            Field[] fields = clazz.getDeclaredFields();
            for(Field f:fields){
                //�ų�serialVersionUID
                if("serialVersionUID".equals(f.getName()))
                    continue;
                //���Ʒ�װ
                f.setAccessible(true);
                //��dest�������ҵ���Ӧ������ֵ��Ȼ��ֵ��origin��Ӧ�����Ե���
                f.set(origin,f.get(dest));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
