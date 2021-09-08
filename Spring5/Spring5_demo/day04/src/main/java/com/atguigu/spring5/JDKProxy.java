package com.atguigu.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Classname JDKProxy
 * @Description TODO
 * @Date 10:18 2021/3/24
 * @Created by hejx
 */

public class JDKProxy {

    public static void main(String[] args) {
        //创建接口实现类的代理对象
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDao1 = new UserDaoImpl();
        /**
         * newProxyInstance方法有三个参数：
         *   第一参数，类加载器
         *   第二参数，增强方法所在的类，这个类实现的接口，支持多个接口
         *   第三参数，实现这个接口 InvocationHandler，创建代理对象，写增强的部分
         */
        UserDao userDao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao1));
        /**
         *切入点：实际被增强的方法
         *
         *
         */
        int result = userDao.add(5, 2);
        System.out.println("result=" + result);
    }

}

class UserDaoProxy implements InvocationHandler {
    //1. 把创建的是谁的代理对象，把谁传递过来
    //有参构造传递
    private Object object;

    public UserDaoProxy(Object obj) {
        object = obj;
    }
    /**
     * 通知（增强）：实际被增强的逻辑部分
     *    前置通知：
     *    后置通知
     *    环绕通知：方法执行前后都通知
     *    异常通知
     *    最终通知 等价finally效果
     * 切面：是动作，把通知应用到切入点的动作
     */
    //增强逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前做处理
        System.out.println("方法之前执行...." + method.getName() + ":传递参数..." + Arrays.toString(args));
        //被增强的方法执行
        Object invoke = method.invoke(object, args);
        //方法之后执行
        System.out.println("方法之后执行...." + object);
        return invoke;  //返回增强的方法
    }
}