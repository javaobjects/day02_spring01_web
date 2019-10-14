package spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		/**
		 * ApplicationContext获取IOC容器的三种方式：
		 * 		1. 【推荐使用】ClassPathXmlApplicationContext 从类路径（class字节码所在路径）下加载xml文件
				2. FileSystemXmlApplicationContext 从文件系统路径下加载xml文件
				3. XmlWebApplicationContext 在web环境中加载xml文件
		 */
		/**
		 * 1. 【推荐使用】ClassPathXmlApplicationContext 从类路径（class字节码所在路径）下加载xml文件，相对于src根路径
		 */
		//① 加载单个配置文件
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		//BeanFactory factory = new ClassPathXmlApplicationContext("config/applicationContext_2.xml");
		
		//② 加载多个配置文件
		//BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml","config/applicationContext_2.xml");
		
		/**
		 * 2. FileSystemXmlApplicationContext 从文件系统路径下加载xml文件，相对于项目根路径
		 */
		//① 相对路径
		//BeanFactory factory = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		//BeanFactory factory = new FileSystemXmlApplicationContext("applicationContext_3.xml");
		//BeanFactory factory = new FileSystemXmlApplicationContext("config/applicationContext_4.xml");
		
		//② 绝对路径
		//BeanFactory factory = new FileSystemXmlApplicationContext("E:\\Workspaces\\Eclipse_JAVA08\\day02_spring01_IOC容器\\config\\applicationContext_4.xml");
		
		/**
		 * 3. XmlWebApplicationContext 在web环境中加载xml文件:
		 * 
		 * 		参考项目：day02_spring01_IOC容器(web)
		 */
		
		//2.获取工厂中的service对象了
		UserService userService = (UserService)factory.getBean("userService");
		
		//3.调用方法
		userService.findUsers();
	}

}
