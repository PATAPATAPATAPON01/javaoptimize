package cglib_proxy;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * Created by PataPon on 2017/8/20.
 * //可以设置对不同的方法执行不同的回调逻辑
 * 返回值为回调数组的索引位置
 */
public class TargetMethodCallbackFilter implements CallbackFilter {
    public int accept(Method method) {
        if (method.getName().equals("method1")) {
            System.out.println("filter method1 ==0");
            return 0;
        }
        if (method.getName().equals("method2")) {
            System.out.println("filter method2 ==1");
            return 1;
        }
        if (method.getName().equals("method3")) {
            System.out.println("filter method3 ==2");
            return 2;
        }
        return 0;
    }
}
