package cglib_proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * Created by PataPon on 2017/8/20.
 */
public class TestCglib {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();

//        enhancer.setCallback(new TargetInterceptor()); //定义代理类的逻辑
        enhancer.setSuperclass(TargetObject.class);

        Callback noopCb = NoOp.INSTANCE;
        Callback callback1 = new TargetInterceptor();
        Callback fixedValue = new TargetResultFixed();
        Callback[] cbarray = new Callback[]{callback1, noopCb, fixedValue};
        enhancer.setCallbacks(cbarray);
        enhancer.setCallbackFilter(new TargetMethodCallbackFilter());
        TargetObject o = (TargetObject) enhancer.create();

        System.out.println(o.method1("mm"));
        System.out.println(o.method2(100));
        System.out.println(o.method3(200));
    }
}
