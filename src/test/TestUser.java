package test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import dao.UserDao;
import daoimplement.UserImplement;
import hibernateutil.SessionAnnotation;
import hibernateutil.SimpleDateFormatUtil;
import model.User;

public class TestUser {
	
		
	@Test
	public void testuser() throws ParseException{
		
		UserDao d=new UserImplement(); 
		/* //模仿注册
		User u=new User();
		u.setUserName("网迦");
		u.setUserTel("13244237897");
		u.setUserBirthday(SimpleDateFormatUtil.getSimpleDateFormat("1996-10-1"));
		u.setUserPassword("666666");
		u.setUserHeadPortr("D:picture\\jiu.jpg");
		u.setUserEmail("888888@qq.com"); 
		if(d.register(u)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		*/
		//System.out.println("登录情况:"+d.login("13244237695", "666666")); //模仿登录
		
		/*
		User u=new User();  //更新测试
		//u.setUserID("Thu Apr 06 20:25:03 CST 2017GsPbI");
		u.setUserName("孙儿娘"); 
		u.setUserHeadPortr("开心就好");
		u.setUserIntegral(5);
		u.setUserMajor("Android工程师");
		u.setUserPassword("666666"); 
		//SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		//String day="2015-5-1";
		//u.setUserBirthday(sf.parse(day)); 
		u.setUserBirthday(SimpleDateFormatUtil.getSimpleDateFormat("1996-10-1"));
		u.setUserTel("13244236656");  
		d.updateUser(u); */
		
		
		
		/*User u=d.selectUser("13244237695");
		System.out.println(u.getUserName());
		
		u=d.selectUser("张三");
		System.out.println(u.toString());
		
		u=d.selectUser("666666@qq.com");
		System.out.println(u.toString());
		*/
		
		
		/*Session session=SessionAnnotation.getSession(); //测试显示用户方法
		String sql="select UserID from User";
		List list=session.createQuery(sql).list();
		for(int i=0;i<list.size();i++){
			User u=d.showUser(list.get(i).toString());
			System.out.println(u.toString());
		}*/
		
		
		
	}


}
