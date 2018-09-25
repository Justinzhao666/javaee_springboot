package top.zhaohaoren.springmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * WebApplicationInitializer接口是spring提供配置servlet3+的
 * 这个是替代web.xml的 -- 目前这里还不是spring boot，还需要放入tomcat中，只是传统的web项目使用smvc
 *
 * 里面的注册应该都相当于在web.xml里面加上一条配置
 */
public class WebInitializer implements WebApplicationInitializer {//1

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyMvcConfig.class);
        ctx.setServletContext(servletContext); // 注册servlet容器关联
        
        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx)); //注册spring mvc的dispatchServlet
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        servlet.setAsyncSupported(true);//1  开启异步方法支持

	}

}
