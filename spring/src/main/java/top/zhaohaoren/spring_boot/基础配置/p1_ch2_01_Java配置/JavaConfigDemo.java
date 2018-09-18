package top.zhaohaoren.spring_boot.基础配置.p1_ch2_01_Java配置;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello()); //useFunctionService由Spring提供的Bean
        context.close();
    }
}
