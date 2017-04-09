package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import dao.UserDao;
import daoimplement.UserImplement;
import hibernateutil.SessionAnnotation;
import hibernateutil.SimpleDateFormatUtil;
import model.Picture;
import model.User;
import util.RandomString;

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
		
		
		
		//测试关联关系
/*		User u1=new User();
		u1.setUserName("二狗子"); 
		u1.setUserHeadPortr("世界次");
		u1.setUserIntegral(6);
		u1.setUserMajor("JAVA工程师");
		u1.setUserPassword("666666"); 
		u1.setUserBirthday(SimpleDateFormatUtil.getSimpleDateFormat("1998-9-1"));
		u1.setUserTel("13244236888");  
		User u2=new User();
		u2.setUserName("大狗子"); 
		u2.setUserHeadPortr("世界次");
		u2.setUserIntegral(6);
		u2.setUserMajor("web工程师");
		u2.setUserPassword("666666"); 
		u2.setUserBirthday(SimpleDateFormatUtil.getSimpleDateFormat("1998-9-2"));
		u2.setUserTel("13244236866");  
		
		Picture p1=new Picture();
		p1.setPID(new Date()+RandomString.getRandomString(5));
	    p1.setPName("餐厅");	
	    p1.setPAddress("D:\\picture\\two.jpg");
	    
		Picture p2=new Picture();
		p2.setPID(new Date()+RandomString.getRandomString(5));
	    p2.setPName("衣服");	
	    p2.setPAddress("D:\\picture\\wwww.jpg");
		
	    u1.getPictures().add(p1);
	    u1.getPictures().add(p2);
	    u2.getPictures().add(p1);
	     //session.save(u1);
	    d.register(u1);
	    d.register(u2);
	    
	    u2.getPictures().add(p2); 
		System.out.println("picture"); 
	    String uid=d.getUserID("13244236888"); 
	    User u3=d.showUser("Sun Apr 09 09:50:20 CST 2017DlLDg");  
	    //User u3=d.showUser(uid); 
	    //System.out.println(uid); 
	    u3.getPictures().add(p2); 
	    d.updateUser(u3); 
	    Set<Picture> ss = u3.getPictures(); 
		System.out.println("picture"); 
	    for (Picture picture : ss) { 
			System.out.println(picture); 
			System.out.println(picture.getPAddress()+" "+picture.getPName()); 
		}*/
		
		
		System.out.println(d.deleteUser("Sun Apr 09 09:50:20 CST 2017DlLDg")); //测试删除user
		
		
/*		try{
			 Session session=SessionAnnotation.getSession();
			    String sql="select RUSERID,RPID from Mark";
//				String sql="select UserID from User";
			    session.beginTransaction();
			    System.out.println("aaaaaaaaaaaa");
			    List list=session.createQuery(sql).list();
			    System.out.println("aaaaaaaaaaaa");
			    System.out.println(list);
			    session.getTransaction().commit();
			    SessionAnnotation.closeSession();
		}catch(Exception e){
			System.out.println(e);
			
		}*/
	    
	  
	    
	}


}
