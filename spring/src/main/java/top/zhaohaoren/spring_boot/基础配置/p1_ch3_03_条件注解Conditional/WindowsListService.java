package top.zhaohaoren.spring_boot.基础配置.p1_ch3_03_条件注解Conditional;

public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
