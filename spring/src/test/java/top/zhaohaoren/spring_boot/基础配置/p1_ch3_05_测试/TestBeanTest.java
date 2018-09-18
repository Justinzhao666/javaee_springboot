package top.zhaohaoren.spring_boot.基础配置.p1_ch3_05_测试;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //junit环境下提供Spring TestContext Framework功能。== 测试专用的context容器？
@ContextConfiguration(classes = {TestConfig.class}) //加载配置
@ActiveProfiles("prod") // 激活哪个profile
public class TestBeanTest {

    @Autowired
    private TestBean testBean;

    @Test
    public void test(){
        String expected =  "prod";
        String actual = testBean.getContent();
        Assert.assertEquals(expected,actual);
    }
}