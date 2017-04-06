package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import dao.UserDao;
import daoimplement.UserImplement;
import model.User;

public class TestUser {
	
		
	@Test
	public void testuser() throws ParseException{
		
		UserDao d=new UserImplement(); 
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd"); //Ä£·Â×¢²á
		User u=new User();
		u.setUserName("×¯åÈ");
		String day="2017-6-6";
		u.setUserTel("13244237897");
		u.setUserBirthday(sf.parse(day));
		u.setUserPassword("666666");
		u.setUserHeadPortr("D:picture\\jiu.jpg");
		u.setUserEmail("7777777@qq.com"); 
		if(d.register(u)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		
		//System.out.println("µÇÂ¼Çé¿ö:"+d.login("13244237695", "666666")); //Ä£·ÂµÇÂ¼
		
		
		
	}


}
