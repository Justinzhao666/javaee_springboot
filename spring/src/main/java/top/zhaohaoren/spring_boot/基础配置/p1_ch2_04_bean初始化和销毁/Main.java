package top.zhaohaoren.spring_boot.基础配置.p1_ch2_04_bean初始化和销毁;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostConfig.class);
        BeanService beanService = context.getBean(BeanService.class);
        PostPreBeanService postPreBeanService = context.getBean(PostPreBeanService.class);
        context.close();
    }
}
