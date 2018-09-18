package top.zhaohaoren.spring_boot.基础配置.p1_ch3_05_测试;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestConfig {

    @Bean
    @Profile("dev")
    public TestBean devTestBean(){
        return new TestBean("dev");
    }
    @Bean
    @Profile("prod")
    public TestBean prodTestBean(){
        return new TestBean("prod");
    }
}
