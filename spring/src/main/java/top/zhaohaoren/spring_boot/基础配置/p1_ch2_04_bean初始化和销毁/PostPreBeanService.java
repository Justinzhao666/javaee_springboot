package top.zhaohaoren.spring_boot.基础配置.p1_ch2_04_bean初始化和销毁;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PostPreBeanService {
    @PostConstruct
    public void init(){
        System.out.println("PostPreBeanService init");
    }

    public PostPreBeanService() {
        System.out.println("PostPreBeanService construct");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("PostPreBeanService destroy");
    }
}
