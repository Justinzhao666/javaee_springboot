package top.zhaohaoren.spring_boot.基础配置.p1_ch2_02_AOP;

import org.springframework.stereotype.Component;

@Component
public class AnnotationFunction {
    @Action(name = "注解拦截add操作")
    public void add(){

    }
}
