/**
 * Created by 小波哥  2019/7/2 14:33
 */
public class test {
    public static void main(String[] args) {
        String s=new String("hello");
        method(s);
        System.out.println(s);
    }

    private static void method(String s) {
        s+="world";
    }
}

