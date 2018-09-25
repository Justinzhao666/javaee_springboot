package top.zhaohaoren.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 核心配置：主要目的是开启自动配置
public class SpringbootApplication {

    public static void main(String[] args) {

//        关闭banner
//        SpringApplication app = new SpringApplication(SpringbootApplication.class);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);

        SpringApplication.run(SpringbootApplication.class, args);

    }
}
