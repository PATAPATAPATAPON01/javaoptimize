package cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InterfaceMaker;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * Created by PataPon on 2017/8/20.
 */
public class TestInterfaceMaker {

    public static void main(String[] args) throws Exception {
        InterfaceMaker interfaceMaker = new InterfaceMaker();
        interfaceMaker.add(TargetObject.class);
        Class<?> targetInterface = interfaceMaker.create();
        for (Method method : targetInterface.getMethods()) {
            System.out.println(method.getName());
        }
        //接口代理并设置代理接口方法拦截
        Object object = Enhancer.create(Object.class, new Class[]{targetInterface}, new MethodInterceptor() {

            public Object intercept(Object obj, Method method, Object[] args,
                                    MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("method1")) {
                    System.out.println("filter method1 ");
                    methodProxy.invokeSuper(obj, args);
                    return "mmmmmmmmm";
                }
                if (method.getName().equals("method2")) {
                    System.out.println("filter method2 ");
                    return 1111111;
                }
                if (method.getName().equals("method3")) {
                    System.out.println("filter method3 ");
                    return 3333;
                }
                return "default";
            }
        });

        Class<?>[] interfaces = object.getClass().getInterfaces();
        System.out.println("打印方法开始");
        Stream.of(interfaces).forEach(System.out::println);
        System.out.println("打印方法结束");
        Method targetMethod1 = object.getClass().getMethod("method3", new Class[]{int.class});
        int i = (Integer) targetMethod1.invoke(object, 33);
        Method targetMethod = object.getClass().getMethod("method1", new Class[]{String.class});
        System.out.println(targetMethod.invoke(object, new Object[]{"sdfs"}));
    }
}
