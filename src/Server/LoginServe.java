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
		 
                    //��ȡ��http��	           //��ȡ������                                                               //��ȡ�˿ں�	
		String str=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"";
				System.out.println(str);
				
		response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html");
		//response.setContentType("text/html;charset=utf8"); //����������� ����д�ڵõ���֮ǰgbk
		String username = request.getParameter("username");
//		username = new String(username.getBytes("iso-8859-1"),"utf-8��);
		String password = request.getParameter("password");
		System.out.println(username + ":" + password);
		
		
		PrintWriter out = response.getWriter(); // ͨ��response�õ��ֽ������

		String msg = null;
		if (username != null && username.equals("lin") && password != null && password.equals("123")) {
			msg = "��ϲ�����ɹ�";
		
			System.out.print("��¼�ɹ���");
		} else {
			msg = "LoginFail";
			System.out.print("��¼ʧ�ܣ�");
		}
		 //out.print(msg); //���͸��ͻ�������
		msg="http://imgstore04.cdn.sogou.com/app/a/100520024/877e990117d6a7ebc68f46c5e76fc47a";
		out.write(msg);
		// out.print("<html><head><title></title></head><body>����ɹ�</body></html>");
		System.out.print("���ӳɹ���");
		
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
		while ((str1 = br.readLine())!= null) // �ж����һ�в����ڣ�Ϊ�ս���ѭ��
		{
		System.out.println(str1);//ԭ���������������
		}

		out.flush();
		out.close();

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	

}
