package top.zhaohaoren.spring_boot.基础配置.p1_ch2_04_bean初始化和销毁;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("top.zhaohaoren.spring_boot.基础配置.p1_ch2_04_bean初始化和销毁")
public class PrePostConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    BeanService beanService(){
        return new BeanService();
    }

    @Bean
    PostPreBeanService postPreBeanService(){
        return new PostPreBeanService();
    }
}
