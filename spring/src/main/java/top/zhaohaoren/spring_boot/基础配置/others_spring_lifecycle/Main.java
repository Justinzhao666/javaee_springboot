package top.zhaohaoren.spring_boot.基础配置.others_spring_lifecycle;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhaohaoren
 */

public class Main {

    /**
     * 配置好config 和 bean对应注解
     * 我们需要使用一个context来初始化容器
     */
    public static void main(String[] args) {

        // 这步执行完成后，所有的bean已经被初始化了。@Lazy懒加载就不会了。
        /*
        Construct被执行
        PostConstruct被执行
        PreDestroy被执行
        * */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        BeanDemo bean = context.getBean(BeanDemo.class);
        BeanDemo bean2 = context.getBean(BeanDemo.class);

        bean.service();
        bean.serviceNewThread();
        bean2.service();

        // 只是说IOC容器会自动去帮你执行，并执行一次。
        /*bean.init();
        bean.destroy();*/

        context.close();
    }

/*
    单例情况下：
        执行结果：
            Construct被执行
            PostConstruct被执行
            正在执行服务
            正在执行服务
            PreDestroy被执行
        分析：
            因为是单例所以只执行一次

    多例情况下：
        执行结果：
            Construct被执行
            PostConstruct被执行
            Construct被执行
            PostConstruct被执行
            正在执行服务
            正在执行服务
        分析：
            这两个注解在多例下表现异常，应该多例不适用！
*/
}
