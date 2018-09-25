package top.zhaohaoren.springmvc.web.ch4_3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zhaohaoren.springmvc.domain.DemoObj;

@RestController //1  方法上不需要再加ResponseBody，默认都是返回数据放入体中（数据是通过配置json才返回json的）。
@RequestMapping("/rest")
public class DemoRestController {
	
	@RequestMapping(value = "/getjson",
			produces={"application/json;charset=UTF-8"}) //2 返回数据为json
	public DemoObj getjson (DemoObj obj){
		return new DemoObj(obj.getId()+1, obj.getName()+"yy");//3
	}
	@RequestMapping(value = "/getxml",
			produces={"application/xml;charset=UTF-8"})//4 返回数据为xml
	public DemoObj getxml(DemoObj obj){
		return new DemoObj(obj.getId()+1, obj.getName()+"yy");
	}

}
