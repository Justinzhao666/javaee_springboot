package top.zhaohaoren.spring_boot.基础配置.p1_ch2_03_EL;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 这里注意： 我使用一个自己写的配置类 该配置类没有扫描下面包，那么那些service的bean就不会被加载？ --是的 componentScan作用不就如此吗？
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig resourceService = context.getBean(ElConfig.class);
        resourceService.outputResource();
        context.close();
    }
}
