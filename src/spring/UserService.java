package spring;

/**
 * 
* <p>Title: UserService</p>  
* <p>
*	Description: 
* 	使用spring的时候，
* 	UserService依赖于IUserDao，
* 	将new对象的权利管理在applicationContext.xml中，
* 	控制权在spring的手里，
* 	即new对象的权利从自己手中反转给了spring（IOC\DI）
*   
* </p> 
* @author xianxian 
* @date 2019年10月14日
 */
public class UserService {

	//IUserDao userDao = DaoFactory.createUserDao();  不再使用工厂new对象，因为耦合度还是比较高，将new对象的权利交给spring
	private IUserDao userDao;
	
	public UserService(IUserDao userDao)
	{
		this.userDao = userDao;
	}
	
	public void findUsers()
	{
	    userDao.selectUser();
	}
}
