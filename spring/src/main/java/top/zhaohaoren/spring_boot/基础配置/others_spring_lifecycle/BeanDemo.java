package top.zhaohaoren.spring_boot.基础配置.others_spring_lifecycle;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zhaohaoren
 */

@Service
//@Scope("prototype")
//@Lazy(false)
public class BeanDemo {

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct被执行");
    }

    public BeanDemo() {
        System.out.println("Construct被执行");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy被执行");
    }

    public void service() {
        System.out.println("正在执行服务service");
        System.out.println("线程："+Thread.currentThread().getId());
    }

    @Async
    void serviceNewThread(){
        System.out.println("正在执行服务serviceNewThread");
        System.out.println("线程："+Thread.currentThread().getId());
    }
}
