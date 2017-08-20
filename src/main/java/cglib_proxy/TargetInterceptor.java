package cglib_proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by PataPon on 2017/8/20.
 */
public class TargetInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println(o.getClass()==TargetObject.class);
        System.out.println("调用前");
        Object result = methodProxy.invokeSuper(o, objects);

        System.out.println("调用方法后result=" + result);
        return result;
    }
}
