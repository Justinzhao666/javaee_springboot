package top.zhaohaoren.spring_boot.基础配置.p1_ch3_05_测试;

public class TestBean {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TestBean(String content) {
        super();
        this.content = content;
    }
}
