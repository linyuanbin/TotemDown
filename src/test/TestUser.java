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
		/* //ģ��ע��
		User u=new User();
		u.setUserName("����");
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
		//System.out.println("��¼���:"+d.login("13244237695", "666666")); //ģ�µ�¼
		
		/*
		User u=new User();  //���²���
		//u.setUserID("Thu Apr 06 20:25:03 CST 2017GsPbI");
		u.setUserName("�����"); 
		u.setUserHeadPortr("���ľͺ�");
		u.setUserIntegral(5);
		u.setUserMajor("Android����ʦ");
		u.setUserPassword("666666"); 
		//SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		//String day="2015-5-1";
		//u.setUserBirthday(sf.parse(day)); 
		u.setUserBirthday(SimpleDateFormatUtil.getSimpleDateFormat("1996-10-1"));
		u.setUserTel("13244236656");  
		d.updateUser(u); */
		
		
		
		/*User u=d.selectUser("13244237695");
		System.out.println(u.getUserName());
		
		u=d.selectUser("����");
		System.out.println(u.toString());
		
		u=d.selectUser("666666@qq.com");
		System.out.println(u.toString());
		*/
		
		
		/*Session session=SessionAnnotation.getSession(); //������ʾ�û�����
		String sql="select UserID from User";
		List list=session.createQuery(sql).list();
		for(int i=0;i<list.size();i++){
			User u=d.showUser(list.get(i).toString());
			System.out.println(u.toString());
		}*/
		
		
		
		//���Թ�����ϵ
/*		User u1=new User();
		u1.setUserName("������"); 
		u1.setUserHeadPortr("�����");
		u1.setUserIntegral(6);
		u1.setUserMajor("JAVA����ʦ");
		u1.setUserPassword("666666"); 
		u1.setUserBirthday(SimpleDateFormatUtil.getSimpleDateFormat("1998-9-1"));
		u1.setUserTel("13244236888");  
		User u2=new User();
		u2.setUserName("����"); 
		u2.setUserHeadPortr("�����");
		u2.setUserIntegral(6);
		u2.setUserMajor("web����ʦ");
		u2.setUserPassword("666666"); 
		u2.setUserBirthday(SimpleDateFormatUtil.getSimpleDateFormat("1998-9-2"));
		u2.setUserTel("13244236866");  
		
		Picture p1=new Picture();
		p1.setPID(new Date()+RandomString.getRandomString(5));
	    p1.setPName("����");	
	    p1.setPAddress("D:\\picture\\two.jpg");
	    
		Picture p2=new Picture();
		p2.setPID(new Date()+RandomString.getRandomString(5));
	    p2.setPName("�·�");	
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
		
		
		System.out.println(d.deleteUser("Sun Apr 09 09:50:20 CST 2017DlLDg")); //����ɾ��user
		
		
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
