package top.zhaohaoren.spring_boot.基础配置.p1_ch3_03_条件注解Conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

    /**
     * config里面每个方法对应着一个bean的返回
     * @Conditional(XXXCondition.class)
     * 添加该注解，spring会去XXXCondition中判断是否满足条件，然后决定是否返回bean
     */



    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowListService(){
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxListService(){
        return new LinuxListService();
    }

    @Bean
    @Conditional(MacCondition.class)
    public ListService macListService() {
        return new MacListService();
    }
}
