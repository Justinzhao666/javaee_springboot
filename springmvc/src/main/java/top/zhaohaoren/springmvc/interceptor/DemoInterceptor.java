package top.zhaohaoren.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 自定义拦截器  集成HandlerInterceptorAdapter
 * 实现preHandle，postHandle
 * 一个在请求前拦截 一个在请求后拦截
 * 该例子使用拦截器获取访问接口时间
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {//1

	@Override
	public boolean preHandle(HttpServletRequest request, //2
			HttpServletResponse response, Object handler) throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, //3
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		request.removeAttribute("startTime");
		long endTime = System.currentTimeMillis();
		System.out.println("本次请求处理时间为:" + new Long(endTime - startTime)+"ms");
		request.setAttribute("handlingTime", endTime - startTime);
	}

}
