package spring.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import spring.UserService;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 3. XmlWebApplicationContext 在web环境中加载xml文件
		 * 
		 * 		需要导入web功能的jar包：spring-web.jar
		 */
		/*XmlWebApplicationContext factory = new XmlWebApplicationContext();
		factory.setServletContext(request.getServletContext());//设置application环境
		factory.setConfigLocation("/WEB-INF/applicationContext.xml");//设置spring核心配置文件路径，默认在/WEB-INF/applicationContext.xml路径下
		factory.refresh();//刷新*/
		
		/**
		 * 3.1 WebApplicationContext 在web环境中加载xml文件
		 * 
		 * 		需要导入web功能的jar包：spring-web.jar
		 * 
		 *      在web.xml中配置如下监听：
		 *      			<!-- 加载spring的核心配置文件 -->
							<context-param>
								<param-name>contextConfigLocation</param-name>
								<!-- <param-value>/WEB-INF/applicationContext.xml</param-value> --><!-- 配置文件在WEB-INF中 -->
								<param-value>classpath:applicationContext.xml</param-value><!-- 配置文件在src中 -->
							</context-param>
						
							<!-- 注册spring监听器 -->
							<listener>
								<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
							</listener>
		 */
		WebApplicationContext factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
		
		//2.获取工厂中的service对象了
		UserService userService = (UserService)factory.getBean("userService");
		
		//3.调用方法
		userService.findUsers();
	}

}
