package top.zhaohaoren.spring_boot.基础配置.p1_ch2_04_bean初始化和销毁;


public class BeanService {

    public void init(){
        System.out.println("BeanService init");
    }

    public BeanService() {
        System.out.println("BeanService construct");
    }

    public void destroy(){
        System.out.println("BeanService destroy");
    }
}
