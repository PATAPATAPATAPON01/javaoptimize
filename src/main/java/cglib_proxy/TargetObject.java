package cglib_proxy;

public class TargetObject {
    public String method1(String paramName) {
        System.out.println("22");
        return paramName;
    }

    public int method2(int count) {
        return count;
    }

    public int method3(int count) {
        return count;
    }

    @Override
    public String toString() {
        return "TargetObject []" + getClass();
    }
}