package daoimplement;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.PictureDao;
import hibernateutil.SessionAnnotation;
import model.Picture;
import util.RandomString;

public class PictureImplement implements PictureDao {

	@Override
	public boolean AddPicture(Picture p) {  //����ͼƬ��Դ
		Session session=SessionAnnotation.getSession();
		p.setPID(new Date()+RandomString.getRandomString(5));
		try{
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		SessionAnnotation.closeSession();
		return true;
		}catch(Exception e){
			System.out.println(e);
			SessionAnnotation.closeSession(); 
			return false;
		}
	}

	@Override
	public boolean updatePicture(Picture p) {
		Session session=SessionAnnotation.getSession();
		try{
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		SessionAnnotation.closeSession();
		return true;
		}catch(Exception e){
			System.out.println(e);
			session.getTransaction().commit();
			SessionAnnotation.closeSession();
			return false;
		}
	}

	@Override
	public boolean deletePicture(String PID) {  //ɾ��ͼƬ
		Session session=SessionAnnotation.getSession();
		session.beginTransaction();
		String sql="select PID from Picture where PID='"+PID+"'";  //�����Ƿ�����û�
		List list=session.createQuery(sql).list();
		
		if(list.isEmpty()){ //�������˵��������
			SessionAnnotation.closeSession();
			return false;
		}
		//"delete from User where User_ID='"+User_ID+"'";
		sql="delete from Picture where UserID='"+PID+"'";
		Query query=session.createQuery(sql);
		query.executeUpdate();
		session.getTransaction().commit(); 
		SessionAnnotation.closeSession(); 
		return true; 
	}

	@Override
	public Set<Picture> selectAllPicture() {  //�������ݿ������е�ͼƬ����
		Session session=SessionAnnotation.getSession();
		session.beginTransaction();
		Set<Picture> pictures=new HashSet<Picture>();
		String sql="select PID from Picture";
		List<String> list=new ArrayList<>();
		list=(List<String>) session.createQuery(sql).list();
		System.out.println("list"+list);
		for(String li:list){
			System.out.println("Pid  "+li);
			Picture p=(Picture) session.get(Picture.class,li);
			pictures.add(p);
		}
		session.getTransaction().commit();
		SessionAnnotation.closeSession();
		return pictures;
	}

	@Override
	public Picture selectSinglePictureFID(String PID) {
		
		try{
			Session session=SessionAnnotation.getSession();
			session.beginTransaction();
			Picture p=(Picture) session.get(Picture.class,PID);
			session.getTransaction().commit();
			session.flush();
			SessionAnnotation.closeSession();
			return p;
		}catch(Exception e){
			System.out.println(e);
			SessionAnnotation.closeSession();
			return null;
		}
	}

	@Override
	public Set<Picture> selectPicturesFN(String PName) {  //��������ƥ��Ķ���ͼƬ
		Session session=SessionAnnotation.getSession();
		session.beginTransaction();
		Set<Picture> pictures=new HashSet<Picture>();
		String sql="select PID from Picture where PNAME like '%"+PName+"%'";
		List<String> list=session.createQuery(sql).list();
		for(String li:list){
			Picture p=(Picture)session.get(Picture.class,li); 
			pictures.add(p); 
		}
		session.getTransaction().commit(); 
		SessionAnnotation.closeSession(); 
		return pictures;
	}

	@Override
	public Set<Picture> selectPicturesFM(String pMark) {
		Session session=SessionAnnotation.getSession();
		session.beginTransaction();
		Set<Picture> pictures=new HashSet<Picture>(); 
		String sql="select PID from Picture where PMARK like '%"+pMark+"%'"; 
		List<String> list=session.createQuery(sql).list(); 
		for(String li:list){ 
			Picture p=(Picture)session.get(Picture.class,li); 
			pictures.add(p); 
		}
		session.getTransaction().commit(); 
		SessionAnnotation.closeSession(); 
		return pictures;
	}

	@Override
	public Picture selectSinglePictureFN(String Pname) { 
		Session session=SessionAnnotation.getSession();
		session.beginTransaction();
		try{
			String sql="select PID from picture where Pname='"+Pname+"'"; 
			List list=session.createQuery(sql).list(); 
			Picture p=(Picture)session.get(Picture.class,list.toString()); 
			session.getTransaction().commit(); 
			SessionAnnotation.closeSession(); 
			return p; 
		}catch(Exception e){
			session.getTransaction().commit();
			SessionAnnotation.closeSession();
			return null;
		}
	
	}
	

}