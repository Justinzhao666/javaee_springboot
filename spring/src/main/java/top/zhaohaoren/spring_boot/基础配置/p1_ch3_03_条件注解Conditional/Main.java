package top.zhaohaoren.spring_boot.基础配置.p1_ch3_03_条件注解Conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

        /**
         * 必须使用到接口，该接口针对不同的系统或者条件有着不同的实现，Bean是我们交给Spring去创建的（在config中创建返回bean）
         *
         * spring容器就会依据你实现的Condition条件判断是否构建bean并返回。
         */
        ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name") + "系统下列表命令为：" + listService.showListCmd());
    }
}
