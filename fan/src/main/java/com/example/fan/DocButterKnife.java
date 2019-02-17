package com.example.fan;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DocButterKnife {

    public static void bind(Activity activity) {
        //1.setContentView(R.layout.activity_main);
        //将视图绘制移入其中
        bindView(activity);

        //2.查找视图内容
        queryContentId(activity);
    }


    private static void queryContentId(Activity activity) {
        //获取类对象
        Class<? extends Activity> clazz = activity.getClass();
        //获取所有的声明字段
        Field[] fields = clazz.getDeclaredFields();
        //遍历循环获取每一个声明的字段
        for (int i = 0; i < fields.length; i++) {
            try {
                Field field = fields[i];
                //获取字段上的注解
                BindView annotation = field.getAnnotation(BindView.class);
                //判空,非空时，也就是可以获取到ID时，再进行赋值的处理
                if (null != annotation) {
                    //实质上就是ID值
                    int id = annotation.value();
                    //借助于Activity
                    View view = activity.findViewById(id);
                    //字段赋值
                    //tv_content=view
                    field.set(activity, view);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }


    //绑定根视图
    private static void bindView(Activity activity) {
        //获取类对象
        Class<? extends Activity> clazz = activity.getClass();
        try {
            //通过类对象获取setContentView(R.layout.activity_main);
            Method method = clazz.getMethod("setContentView", int.class);
            //通过类型获取注解
            DocLayout annotation = clazz.getAnnotation(DocLayout.class);
            int layout = annotation.value();
            //如果能获取到方法再向下执行
            if (null != method) {
                method.invoke(activity, layout);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}