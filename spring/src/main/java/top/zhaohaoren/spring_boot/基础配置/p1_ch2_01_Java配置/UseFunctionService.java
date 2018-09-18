package top.zhaohaoren.spring_boot.基础配置.p1_ch2_01_Java配置;
/**
 *  该类也不写@Service和@AutoWired,这样spring就不会去处理该实例。
 *  我们转用Config对其创建Bean和注入。
 * */
public class UseFunctionService {
    FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String sayHello() {
        return functionService.sayHello();
    }
}
