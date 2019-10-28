package com.zxj.demo.test;

/**
 * Created by upc on 2019/9/27.
 */

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * 项目名称：Test1 类名称：Test2 类描述： 创建人：admin 创建时间：2017年1月7日 下午9:41:36 修改人：admin
 * 修改时间：2017年1月7日 下午9:41:36 修改备注：
 *
 * @version
 *
 */
class Test6 {
    public static final int a = 6 / 2;// 编译时就处理了，即i = 3
    // 3;不初始化类，static代码块和静态初始化块不执行
    public static final int b = new Random().nextInt(10);// 运行时处理，需要初始化类，都执行
    static {
        System.out.println("Test6  static 静态代码块" + a + ":" + b);
    }
    {
        System.out.println("Test6  初始化块");

    }
}

class Test4 extends Test6 {
    public static final int i = 6 / 2;// 编译时就处理了，即i = 3
    // 3;不初始化类，static代码块和静态初始化块不执行
    public static final int j = new Random().nextInt(10);// 运行时处理，需要初始化类，都执行
    static {
        System.out.println("Test4  static 静态代码块" + i + ":" + j);
    }
    {
        System.out.println("Test4  初始化块");
    }

}

public class Test3 {

    /**
     * @param args
     *            2017年1月7日
     */
    static {
        System.out.println("Test3");
    }

    public static void main(String[] args) {
//         Test4 t = new Test4();//结果如下：执行了初始化块
        // Test3
        // Test6 static 静态代码块3:9
        // Test4 static 静态代码块3:0
        // Test6 初始化块
        // Test4 初始化块
        /***********************************************************/
         System.out.println(Test4.j);// 这个不执行初始化块
        // Test3
        // Test6 static 静态代码块3:4
        // Test4 static 静态代码块3:8
        // 8
        /***********************************************************/
//        System.out.println(Test4.b);// 不会初始化Test4，因为b定义在了Test6
        // Test3
        // Test6 static 静态代码块3:8
        // 8

    }
}
