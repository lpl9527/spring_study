package com.lpl.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂类
 *      Bean:在计算机语言中，有可重用组件的含义。
 * 用于帮我们创建service和dao层对象的。
 *      第一步：通过一个配置文件来配置service和dao中的Bean；
 *              配置的内容： Bean对象唯一标识（id）：Bean对象的全限定类名（class）
 *              配置文件可以使用xml或者properties格式文件。
 *      第二步：通过读取配置文件，反射创建对象；
 *
 */
public class BeanFactory {

    //定义一个Properties对象
    private static Properties props;

    //定义一个Map作为容器，用于存放创建的对象，实现单例
    private static Map<String, Object> beans;

    //通过静态代码块为Properties对象赋值
    static{
        try {
            props = new Properties();
            //获取当前对象的类加载器然后获取到properties文件的字节流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            //将配置文件内容放入Properties对象中
            props.load(in);

            //实例化容器，将配置文件中所有的Bean配置反射创建对象并放入容器中
            beans = new HashMap<String, Object>();
            //取出配置文件中的所有key
            Enumeration keys = props.keys();
            //遍历枚举
            while(keys.hasMoreElements()){
                //取出每个对象的名称
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //将key和value放入容器中
                beans.put(key, value);
            }

        } catch (Exception e) {
            throw new ExceptionInInitializerError("读取配置文件并初始化Properties对象异常！");
        }
    }

    /**
     * 获取properties文件中配置的对象，测试对象已经是单例的了
     * @param beanName  属性文件中配置的Bean对象的名称
     * @return  反射创建的对象
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

    /*public static Object getBean(String beanName){
        //要创建并返回的Bean对象
        Object bean = null;
        try{
            //获取Bean对象的全限定类名
            String beanPath = props.getProperty(beanName);
            //System.out.println("反射创建的对象全限定类名： " + beanPath);
            //反射创建
            bean = Class.forName(beanPath).newInstance();   //每次都会调用默认构造创建对象
            //System.out.println("反射创建的对象 ： " + bean);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("读取配置文件反射创建Bean异常！");
        }
        return bean;
    }*/
}
