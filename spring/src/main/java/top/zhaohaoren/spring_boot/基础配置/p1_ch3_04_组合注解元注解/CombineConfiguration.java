package top.zhaohaoren.spring_boot.基础配置.p1_ch3_04_组合注解元注解;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration // 将configuration注解当做元注解进行组合
@ComponentScan // 同上
public @interface CombineConfiguration {
    String[] value() default {}; //覆盖value参数
}

