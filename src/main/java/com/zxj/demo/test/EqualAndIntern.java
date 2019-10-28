package com.zxj.demo.test;

/**
 * Created by upc on 2019/7/21.
 */
public class EqualAndIntern {
    public static void main(String[] arg) {
//        System.out.println(Math.round(-12.5));//-12
//        String str1="hello world";
//        String str2="hello"+new String(" world");
//        System.out.println(str1.hashCode());
//        System.out.println(str1==str2);//false
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        int iA=1;
        int iE=321;
        int iF=321;
        System.out.println(a.equals(iA));//true 使用equal的时候会对基本数据类型进行装箱操作，因为基本类型没有equal方法，调用equal方法的只能是包装类，而Integer类中重写的equals方法参数是一个Object类型，所以会对基本数据类型装箱
        System.out.println(a==iA);//true 使用==的时候会对包装类型进行拆箱操作然后比较值
        System.out.println(iE==iF);//true 因为两个都是基本类型，所以==都是直接比较值
        System.out.println(iF==iE);//true 使用==的时候会对包装类型进行拆箱操作然后比较值

        Integer nA =new Integer(1);
        Integer nB =new Integer(1);
        System.out.println(a==nA);//false new出来的对象地址肯定不一样，所以用==去比较返回false
        System.out.println(nA==nB);//false new出来的对象地址肯定不一样，所以用==去比较返回false
        System.out.println(iA==nB);//true 这里有基本数据类型，所以会自动拆箱比较值

        System.out.println(c == d);//true Integer内部存了-128~127的数，当值在这个范围内的时候直接取这里的值，不会创建新的对象
        System.out.println(e == f);//false 超出-128~127这个范围的Integer对象则使用==无法得到正确的结果,因为每创建一个Integer对象,就回获取一个新的对象地址的引用;
        System.out.println(c == (a + b));//true   a+b包含了算术运算，因此会触发自动拆箱过程（会调用intValue方法）,==比较符又将左边的自动拆箱，因此它们比较的是数值是否相等。
        System.out.println(c.equals(a + b));//true a+b先拆箱计算值然后再装箱，数据类型还是Integer
        System.out.println(g == (a + b));//true  a+b运算会自动拆箱，因为 == 比较符会自动拆箱，所以直接比较值
        System.out.println(g.equals(a + b));//false    equals 运算符不会进行类型转换所以里面a+b先拆箱计算值然后再装箱，因为外面g为Long类型，所以类型不匹配返回false
        System.out.println(g.equals(a + h));//true  运算符+会进行类型转换，a+h各自拆箱之后是int+long，结果是long，然后long进行自动装箱为Long，两个Long进行equals判断



        String string = new String("tst");
        System.out.println(string.hashCode());
        System.out.println(Math.round(-1.5));//-1
        System.out.println(Math.floor(-0.5));   //-1.0
//        //只在堆上创建AABB对象，没有在常量池中创建常量AABB
//        String a3 = "A";
//        String a2 = new String("AA") + new String("BB");
//        String a1 = new String("A");
//        String a4 = new String("A") + new String("A");//只在堆上创建对象AA
//        a4.intern();//将该对象AA的引用保存到常量池上
//        String a6=new String("AA");
//        String a5="AA";
//        System.out.println(a4 == a6); //false
//        System.out.println(a4 == a5); //false
//        System.out.println(a6 == a5); //false
//        System.out.println(a3 == a3.intern()); //true
//        System.out.println(a1 == a3); //false
//        System.out.println(a2 == a2.intern()); //true


        String a3 = new String("AA");    //在堆上创建对象AA
        a3.intern(); //在常量池上创建对象AA的引用
        String a4 = "AA"; //常量池上存在引用AA，直接返回该引用指向的堆空间对象，即a3
//        System.out.println(a3.intern());
        System.out.println(a3.intern() == a3); //false
        System.out.println(a3.intern() == a4.intern()); //true
        System.out.println(a3.intern() == a4); //true
        System.out.println(a4.intern() == a4); //true
        String a1 = "AA";//在常量池上创建常量AA
        String a2 = "AA";//直接返回已经存在的常量AA
        System.out.println(a1 == a2); //true
        String a6=new StringBuilder("A").append("A").toString();
        System.out.println("---------------------"); //true
        System.out.println(a1==a6);
        String s1 = "hello" + "word";
        String s2 = "helloword";
        System.out.println(s1 == s2);//true
        String s3 = new String("hello") +new String( "word");
        String s4= new String("helloword");
        System.out.println(s3 == s4);//true
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);

        //常量AA不存在，所以第一步在常量池中创建了常量CC
//        String c2 = new String("CC") + new String("DD");
        String c3 = new String("C")+new String("C"); //在堆中创建对象引用CC，在常量池中创建C，因为CC对象在常量池中没有，所以c3.intern()返回堆 的对象引用
//        System.out.println(c3 == c3.intern()); //true、c3.intern()现在返回的是c3在常量池中的地址，这个地址是由c3在堆中创建，但是因为没有这个常量，所以把堆中字符串地址复制到了常量池中
//        intern方法还是会先去查询常量池中是否有已经存在，如果存在，则返回常量池中的引用，如果在常量池找不到对应的字符串，则不会再将字符串拷贝到常量池，而只是在常量池中生成一个对原字符串的引用。
//        c3.intern();//加上的话底下四个都会是true，去掉的话只有倒数第二个和倒数第三个是true，因为调用intern函数的话会把堆中的字符串引用复制到常量池中，以后有其他变量去调用CC这个字符串的时候都是获取的是c3在堆中的地址
        String c4="CC";//如果intern()方法加上因为常量池在c3创建的时候没有CC这个字符串常量，所以将堆中的CC地址引用复制到了常量池中，所以c4现在是一个指向堆中的c3，如果去掉c3.intern();方法，此时常量池里是没有CC这个字符串变量的，
        //所以会在常量池中创建CC的常量，并返回CC的引用给c4
        System.out.println(c3 == c3.intern()); //
        System.out.println(c4 == c3.intern()); //、c4是常量池中的常量对应的引用
        System.out.println(c4 == c4.intern()); //、c4是常量池中的常量对应的引用
        System.out.println(c4 == c3); //、c4是常量池中的常量
    }
}
