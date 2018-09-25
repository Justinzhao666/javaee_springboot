package top.zhaohaoren.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import top.zhaohaoren.springmvc.interceptor.DemoInterceptor;
import top.zhaohaoren.springmvc.messageconverter.MyMessageConverter;

import java.util.List;


/**
 * 配置类： 相当于spring的xml
 */

@Configuration
@EnableWebMvc// 开启一些默认配置，不开启很多配置无效
@EnableScheduling //开启计划任务支持
@ComponentScan("top.zhaohaoren.springmvc")
public class MyMvcConfig extends WebMvcConfigurerAdapter {// 2

    /**
     * 配置jsp的ViewResolver
     * 映射路径和实际页面的位置
     * <p>
     * View的作用就是整合model request Response渲染成页面
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /**
     * 静态资源直接访问，所有这些路径下的请求都不走接口，直接返回。
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/assets/**") // 指定对外暴露的路径，访问路径下面这些资源直接返回
                .addResourceLocations("classpath:/assets/"); // 指定文件放置的目录

    }

    // region 注册拦截器
    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {// 2
        registry.addInterceptor(demoInterceptor());
    }
    // endregion

    /**
     * 如果接口只是简单的进行页面跳转，那么直接配置在这里就可以
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        //文件上传
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
        registry.addViewController("/sse").setViewName("/sse");
        registry.addViewController("/async").setViewName("/async");
    }

    // url 带 . 的参数点之后的数据会被忽略，配置该参数不被忽略
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    // 文件上传配置
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

    @Bean
    public MyMessageConverter converter() {
        return new MyMessageConverter();
    }


}
