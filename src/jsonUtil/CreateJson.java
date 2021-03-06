package jsonUtil;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import model.Picture;
import model.User;

public class CreateJson {
	
	static {
		try{		
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		}catch (Exception e) {
		System.out.println(e);
		}
	}
	
	public static final ThreadLocal<Gson> gsons =new ThreadLocal<Gson>();

	public static User getUser(String json) {
		User u = new User();
		Gson gson=gsons.get();
		if(gson==null){
			gson=new Gson();
			gsons.set(gson);
		}
		u = gson.fromJson(json, User.class);
		return u;
	}
	
	public static Picture getPicture(String json){
		Picture p=new Picture();
		Gson gson=gsons.get();
		if(gson==null){
			gson=new Gson();
			gsons.set(gson);
		}
		p=gson.fromJson(json,Picture.class);
		return p;
	}

}
