package top.zhaohaoren.springmvc.web.ch4_6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zhaohaoren.springmvc.service.DemoService;

//@Controller
public class NormalController {
	@Autowired
	DemoService demoService;

	@RequestMapping("/normal")
	public  String testPage(Model model){
		model.addAttribute("msg", demoService.saySomething());
		return "page";
	}

}
