package top.zhaohaoren.springmvc.web.ch4_4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zhaohaoren.springmvc.domain.DemoObj;

// 测试全局异常检测
@Controller
public class AdviceController {
	@RequestMapping("/advice")
	public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj){//1
		
		throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute:"+ msg);
	}

}
