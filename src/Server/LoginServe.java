package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UserDao;
import daoimplement.UserImplement;
import jsonUtil.CreateJson;
import model.Picture;
import model.User;

public class LoginServe extends HttpServlet {

	private UserDao d = new UserImplement();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取“http” //获取服务名 //获取端口号
		String str = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "";
		System.out.println(str);

		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		// request.setCharacterEncoding("utf-8");
		// response.setContentType("text/html");
		// response.setContentType("text/html;charset=utf8"); //解决中文乱码
		// 必须写在得到流之前gbk
		String username = new String(request.getParameter("username").getBytes("iso-8859-1"), "utf-8");
		// String username = request.getParameter("username");
		// username = new String(username.getBytes("iso-8859-1"),"utf-8”);
		String password = request.getParameter("password");
		System.out.println(username + ":" + password);

		PrintWriter out = response.getWriter(); // 通过response得到字节输出流
		String msg = null;
		if (username != null && username.equals("lin") && password != null && password.equals("123")) {
			
			System.out.print("登录成功！");
			msg = "http://imgstore04.cdn.sogou.com/app/a/100520024/877e990117d6a7ebc68f46c5e76fc47a";
			out.write(msg);
			BufferedReader br = request.getReader();
			String str1 = null;
			StringBuilder resource = new StringBuilder();
			while ((str1 = br.readLine()) != null) // 判断最后一行不存在，为空结束循环
			{
				resource.append(str1);
				System.out.println(str1);// 原样输出读到的内容
			}

			User u = CreateJson.getUser(resource.toString());
			System.out.println(u.getUserName());
			System.out.println(u.getUserTel());
			System.out.println(u.getUserPassword());
			System.out.println("userID" + u.getUserID());
			if (u.getState().equals("login")) {               // 登录
				String UserId = d.login(u.getUserName(), u.getUserPassword());
				System.out.println("密码正确 用户ID" + UserId);
				msg=UserId;
				out.write(msg);  //登录是向用户反馈UserId
			} else if (u.getState().equals("register")) {     // 注册
				boolean b = d.register(u);
				System.out.println("注册情况：" + b);
				if (b) {// 如果注册成功
					msg = u.getUserID(); //注册成功反馈UserId
					out.write(msg);
				} else {
					msg = "false";       //注册失败回馈
					out.write(msg);
				}
			} else if (u.getState().equals("update")) {        // 更新用户
				/*
				 * String UserId=d.getUserID(u.getUserTel());
				 * System.out.println("查询用户id"+UserId);
				 */
				d.updateUser(u);
				System.out.println("用户生日：" + u.getUserBirthday().toLocaleString());
			}else if(u.getState().equals("request  ")){        //推送请求
				 
				
			}else if(u.getState().equals("mark")){             //打标签
				User user=d.showUser(u.getUserID());
				Picture p=CreateJson.getPicture(resource.toString());
				user.getPictures().add(p);
			}

		} else {
			msg = "LoginFail";
			System.out.print("登录失败！");
		}
		// out.print(msg); //传送给客户端数据

		out.flush();
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
