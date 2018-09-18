package top.zhaohaoren.spring_boot.基础配置.p1_ch3_02_多线程;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

    @Async //该注解表明该方法是个异步方法，会交给线程池去执行。 如果加在类上面则该类所有的方法都是异步方法。
    public void executeAsyncTask(Integer i) {
        System.out.println("执行异步任务：" + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("执行异步任务+1：" + (i + 1));
    }
}
