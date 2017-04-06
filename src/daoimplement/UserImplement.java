package daoimplement;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import dao.UserDao;
import hibernateutil.SessionAnnotation;
import hibernateutil.ValidatorUserNameUtil;
import model.User;
import util.RandomString;

public class UserImplement implements UserDao {

	@Override
	public boolean register(User u) { // ���ε��������û�

		u.setUserID(new Date()+RandomString.getRandomString(5)); //��������û�ID
		Session session = SessionAnnotation.getSession(); 
		try { 
			session.beginTransaction();  
			session.save(u); 
			session.flush(); 
			session.getTransaction().commit();  
			SessionAnnotation.closeSession();  
			return true;

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public String login(String UserName, String Password) {
		Session session=SessionAnnotation.getSession();
		String sql;
		
		if(ValidatorUserNameUtil.isEmail(UserName)){
		sql="select UserID from User where UserEmail='"+UserName+"'and UserPassword='"+Password+"'";	
		}else if(ValidatorUserNameUtil.isMobile(UserName)){
			sql="select UserID from User where UserTel='"+UserName+"'and UserPassword='"+Password+"'";	
		}else{
			sql="select UserID from User where UserName='"+UserName+"'and UserPassword='"+Password+"'";	
		}
		session.beginTransaction();
		List list=session.createQuery(sql).list();
		if(list.isEmpty()){
			 session.getTransaction().commit();
		SessionAnnotation.closeSession();
		return null;
	      }
		String userId=(String) list.iterator().next();
		 session.getTransaction().commit();
		SessionAnnotation.closeSession();
	return userId;
	}

	
	@Override
	public boolean deleteUser(String UserId) {
		Session session=SessionAnnotation.getSession();
		session.beginTransaction();
		String sql="select UserID from User where UserID='"+UserId+"'";  //�����Ƿ�����û�
		List list=session.createQuery(sql).list();
		
		if(list.isEmpty()){ //�������˵��������
			SessionAnnotation.closeSession();
			return false;
		}
		//"delete from User where User_ID='"+User_ID+"'";
		sql="delete from User where UserID='"+UserId+"'";
		Query query=session.createQuery(sql);
		query.executeUpdate();
		session.getTransaction().commit();
		SessionAnnotation.closeSession();
		return true;
	}

	@Override
	public void updateUser(User u) { //����
		Session session=SessionAnnotation.getSession();
		session.beginTransaction();
		session.update(u);
		 session.getTransaction().commit(); 
		 SessionAnnotation.closeSession();
	}

	
	@Override
	public User selectUser(String UserName) {  //�û��Ƿ����
		Session session=SessionAnnotation.getSession();
		String sql;
		if(ValidatorUserNameUtil.isEmail(UserName)){
			sql="select UserID from User where UserEmail='"+UserName+"'";
		}else if(ValidatorUserNameUtil.isMobile(UserName)){
			sql="select UserID from User where UserTel='"+UserName+"'";
	
		}else{
			sql="select UserID from User where UserName='"+UserName+"'";
		}
		session.beginTransaction();
		List list=session.createQuery(sql).list();
		if(!list.isEmpty()){ //�������
			User user=(User)list.iterator().next();
			session.getTransaction().commit();
			SessionAnnotation.closeSession();
			return user;
		}
		SessionAnnotation.closeSession();
		return null;
	}

	@Override
	public boolean senseUser(String UserID) {
		Session session=SessionAnnotation.getSession();
		String sql;
		sql="select UserID from User where UserID='"+UserID+"'";
		session.beginTransaction();
		List list=session.createQuery(sql).list();
		if(!list.isEmpty()){
			session.getTransaction().commit();
			SessionAnnotation.closeSession();
			return true;
		}
		return false;
	}

	@Override
	public User showUser(String UserID) {
		
		return null;
	}
	
	

}