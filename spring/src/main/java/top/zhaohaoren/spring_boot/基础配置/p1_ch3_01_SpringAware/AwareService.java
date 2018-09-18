package top.zhaohaoren.spring_boot.基础配置.p1_ch3_01_SpringAware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * Aware的作用
 * 本例子表明：
 * 我们通过实现 BeanNameAware 和 ResourceLoaderAware可以获取到spring容器为该Service类创建的bean的name和资源加载器
 */

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {


    private String beanName;
    private ResourceLoader loader;


    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    void outputResult(){
        System.out.println("Bean的名称为："+beanName);
        Resource resource = loader.getResource("classpath:test.txt");
        try {
            System.out.println("ResourceLoader 加载的文件内容为："+ IOUtils.toString(resource.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
