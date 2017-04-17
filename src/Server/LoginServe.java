package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServe extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
                    //获取“http”	           //获取服务名                                                               //获取端口号	
		String str=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"";
				System.out.println(str);
				
		response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html");
		//response.setContentType("text/html;charset=utf8"); //解决中文乱码 必须写在得到流之前gbk
		String username = request.getParameter("username");
//		username = new String(username.getBytes("iso-8859-1"),"utf-8”);
		String password = request.getParameter("password");
		System.out.println(username + ":" + password);
		
		
		PrintWriter out = response.getWriter(); // 通过response得到字节输出流

		String msg = null;
		if (username != null && username.equals("lin") && password != null && password.equals("123")) {
			msg = "恭喜你登入成功";
		
			System.out.print("登录成功！");
		} else {
			msg = "LoginFail";
			System.out.print("登录失败！");
		}
		 //out.print(msg); //传送给客户端数据
		msg="http://imgstore04.cdn.sogou.com/app/a/100520024/877e990117d6a7ebc68f46c5e76fc47a";
		out.write(msg);
		// out.print("<html><head><title></title></head><body>登入成功</body></html>");
		System.out.print("连接成功！");
		
		/*ServletInputStream is = request.getInputStream();
		StringBuilder sb = new StringBuilder();
		int len = 0;
		byte[] buf = new byte[1024];
		while((len = is.read(buf))!=-1)
		{
			sb.append(new String (buf , 0, len ));
		
		}
		System.out.println(sb.toString());*/
		
		BufferedReader br =  request.getReader();
		String str1 = null;
		while ((str1 = br.readLine())!= null) // 判断最后一行不存在，为空结束循环
		{
		System.out.println(str1);//原样输出读到的内容
		}

		out.flush();
		out.close();

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	

}
