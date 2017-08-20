package jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by PataPon on 2017/8/20.
 */
public class JdkInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(proxy instanceof Proxy);


        System.out.println(proxy instanceof IDBQuery);
        System.out.println(method.getName());
        return null;
    }
}
