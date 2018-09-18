package top.zhaohaoren.spring_boot.基础配置.p1_ch3_04_组合注解元注解;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 学的远远不到位： 注解在开发中的使用到底怎么才好？
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CombineConfiguration.class);
        BeanService beanService = context.getBean(BeanService.class);
        beanService.output();
        context.close();
    }
}
