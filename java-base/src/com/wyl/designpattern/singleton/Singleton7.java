package com.wyl.designpattern.singleton;

/**
 * @auther yanl.wang
 * @date 2023/1/7
 * 静态内部类
 *
 * 在内部类被加载和初始化时，才创建INSTANCE实例对象
 * 静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的。
 * 用的时候才会加载和初始化
 * 因为是在内部类加载和初始化时创建的，因此是线程安全的，(是类加载器对他加载的)
 **/
public class Singleton7 {

    private Singleton7(){}

    private static class Singleton7Instance{
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance(){
        return Singleton7Instance.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Singleton7.getInstance().hashCode());
            }).start();
        }
    }
}
