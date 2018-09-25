package top.zhaohaoren.springmvc.web.ch4_3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zhaohaoren.springmvc.domain.DemoObj;

import javax.servlet.http.HttpServletRequest;

@Controller // 1
@RequestMapping("/anno") //2
public class DemoAnnoController {

	@RequestMapping(produces = "text/plain;charset=UTF-8")	// 3 指定返回Response的媒体类型和字符集 - 返回文本
	public @ResponseBody String index(HttpServletRequest request) { // 4 这个地方什么鬼？要看看以前的东西。这是之前servlet的，现在mvc中也能用。
		return "url:" + request.getRequestURL() + " can access";
	}

	@RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")// 5
	public @ResponseBody String demoPathVar(@PathVariable String str, //3
			HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access,str: " + str;
	}

	@RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8") //6
	public @ResponseBody String passRequestParam(Long id,
			HttpServletRequest request) {
		
		return "url:" + request.getRequestURL() + " can access,id: " + id;

	}

	@RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")//7 返回json
	@ResponseBody //8
	public String passObj(DemoObj obj, HttpServletRequest request) {
		
		 return "url:" + request.getRequestURL() 
		 			+ " can access, obj id: " + obj.getId()+" obj name:" + obj.getName();

	}

	@RequestMapping(value = { "/name1", "/name2" }, produces = "text/plain;charset=UTF-8")//9
	public @ResponseBody String remove(HttpServletRequest request) {
		
		return "url:" + request.getRequestURL() + " can access";
	}

}
