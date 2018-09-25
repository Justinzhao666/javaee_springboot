package top.zhaohaoren.springmvc.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


/**
 * @ControllerAdvice 这个注解AOP，针对所有的@Controller类全局有效
 */
@ControllerAdvice //1
public class ExceptionHandlerAdvice {

	/**
	 * 全局的异常处理
	 * ：人性化输出异常
	 * question： 这些View ModelAndView Model是啥玩意？
	 */
	@ExceptionHandler(value = Exception.class)//2
	public ModelAndView exception(Exception exception, WebRequest request) {
		ModelAndView modelAndView = new ModelAndView("error");// error页面
		modelAndView.addObject("errorMessage", exception.getMessage());
		return modelAndView;
	}

	/**
	 * model中放入键值对，全局可用。
	 * 所有的requestMapping方法都可以获取到该键值对
	 */
	@ModelAttribute //3
	public void addAttributes(Model model) {
		model.addAttribute("msg", "额外信息"); //3
	}

	/**
	 * 不知道干啥的，以后琢磨。
	 */
	@InitBinder //4
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("id"); //5
	}
}
