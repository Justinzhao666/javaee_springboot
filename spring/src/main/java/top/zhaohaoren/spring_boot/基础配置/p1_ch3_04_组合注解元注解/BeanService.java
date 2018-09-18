package top.zhaohaoren.spring_boot.基础配置.p1_ch3_04_组合注解元注解;

import org.springframework.stereotype.Service;

@Service
public class BeanService {
    public void output(){
        System.out.println("组合注解获取bean");
    }
}
