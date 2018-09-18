package top.zhaohaoren.spring_boot.基础配置.p1_ch2_02_AOP;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("top.zhaohaoren.spring_boot.基础配置.p1_ch2_02_AOP")
@EnableAspectJAutoProxy //主要这个注解：开启Spring对AspectJ代理的支持，似乎纯粹就是配置
public class AopConfig {
}
