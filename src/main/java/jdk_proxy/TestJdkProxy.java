package jdk_proxy;

import java.lang.reflect.Proxy;

/**
 * Created by PataPon on 2017/8/20.
 */
public class TestJdkProxy {

    public static void main(String[] args) {


        IDBQuery instance = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IDBQuery.class}, new JdkInvocationHandler());


        System.out.println(instance instanceof Proxy);


        System.out.println(instance instanceof IDBQuery);
        instance.duQuery(1);
    }
}
