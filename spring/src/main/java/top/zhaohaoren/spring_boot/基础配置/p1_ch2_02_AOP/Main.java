package top.zhaohaoren.spring_boot.基础配置.p1_ch2_02_AOP;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        AnnotationFunction annotationFunction = context.getBean(AnnotationFunction.class);
        MethodFunction methodFunction = context.getBean(MethodFunction.class);
        annotationFunction.add();
        methodFunction.add();
        context.close();
    }
}
