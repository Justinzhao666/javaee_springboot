package top.zhaohaoren.spring_boot.基础配置.p1_ch2_03_EL;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;


@Configuration
@ComponentScan("top.zhaohaoren.spring_boot.基础配置.p1_ch2_03_EL")
@PropertySource("classpath:test.properties")
public class ElConfig {

    /*注入普通字符串*/
    @Value("hello")
    private String normal;

    /*注入操作系统属性*/
    @Value("#{systemProperties['os.name']}")
    private String osName;

    /*注入表达式结果*/
    @Value("#{ T(java.lang.Math).random() *100.0}")
    private double randomNumber;

    /*注入其他bean的属性值*/
    @Value("#{demoService.another}")
    private String fromAnother;

    /*注入配置文件配置值 使用{} */
    @Value("${book.name}")
    private String bookName;

    /*注入文件资源*/
    @Value("classpath:test.txt")
    private Resource testFile;

    /*注入网址资源*/
    @Value("http://www.baidu.com")
    private Resource testUrl;

    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
